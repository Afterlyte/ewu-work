<h1 style="background-color:white">Names</h1>
<h2 style="text-align:left; padding-left:0">Here is <?php echo $num ?> in English words</h2>
<p><strong><?php numInWords($num); ?></strong></p>
<br>
<h2 style="text-align:left; padding-left:0">Here is <?php echo $num ?> in Roman Numerals</h2>
<p><strong><?php romanNumerals($num); ?></strong></p>
<?php
/**
 * Ian Kaiserman
 * Assignment 3: Fun With Integers
 * PHP file for calling and displaying functions and HTML related to the Names info
 */

include "inputs.php";

function romanNumerals($num) {
    if($num > 4999) {
        echo "Number too large to write in Roman Numerals. Please try another number. <br>";
        return "";
    }
    $numerals = "";
    while($num - 1000 >= 0) {
        $numerals .= "M";
        $num -= 1000;
    }
    if($num >= 900) {
        $numerals .= "CM";
        $num -= 900;
    }
    if($num - 500 >= 0) {
        $numerals .= "D";
        $num -= 500;
    }
    if($num - 400 >= 0) {
        $numerals .= "CD";
        $num -= 400;
    }
    while($num - 100 >= 0) {
        $numerals .= "C";
        $num -= 100;
    }
    if($num - 90 >= 0) {
        $numerals .= "XC";
        $num -= 90;
    }
    if($num - 50 >= 0) {
        $numerals .= "L";
    }
    if($num >= 40) {
        $numerals .= "XL";
        $num -= 40;
    }
    while($num - 10 >= 0) {
        $numerals .= "X";
        $num -= 10;
    }
    if($num == 9) {
        $numerals .= "IX";
        $num -= 9;
    }
    if($num - 5 >= 0) {
        $numerals .= "V";
        $num -= 5;
    }
    if($num == 4) {
        $numerals .= "IV";
        $num -= 4;
    }
    while($num > 0) {
        $numerals .= "I";
        $num--;
    }
    echo $numerals, '<br>';
}

function numInWords($num) {
    if($num == 0) {
        echo "zero";
    }
    $words = "";
    if(strlen($num) > 9) {
        $words .= convertSection(substr($num, 0, strlen($num) - 9)) . " billion ";
        $num = substr($num, strlen($num) - 9, strlen($num));
    }
    while($num != "" && $num[0] == 0) {
        $num = substr($num, 1, strlen($num));
    }
    if(strlen($num) > 6) {
        $words .= convertSection(substr($num, 0, strlen($num) - 6)) . " million ";
        $num = substr($num, strlen($num) - 6, strlen($num));
    }
    while($num != "" && $num[0] == 0) {
        $num = substr($num, 1, strlen($num));
    }
    if(strlen($num) > 3) {
        $words .= convertSection(substr($num, 0, strlen($num) - 3)) . " thousand ";
        $num = substr($num, strlen($num) - 3, strlen($num));
    }
    $words .= convertSection($num);
    echo $words, '<br>';
}

function convertSection($s) {
    $res = "";
    if($s[0] == 0) {
        $s = substr($s, 1, strlen($s));
    }
    $underTen = array("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
    $underTwenty = array("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");
    $tenMultiples = array("twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety");
    if($s > 99) {
        $res .= $underTen[$s[0]] . " hundred ";
        $s = substr($s, 1, strlen($s));
    }
    if($s > 9) {
        if($s < 20) {
            return $res . $underTwenty[$s % 10];
        }
        else {
            $res .= $tenMultiples[$s / 10 - 2];
            if($s[1] != 0) {
                $res .= "-";
            }
            else {
                return $res;
            }
        }
        $s = substr($s, 1, strlen($s));
    }
    if($s != 0) {
        $res .= $underTen[$s + 0];
    }
    else {
        $res = substr($res, 0, strlen($res) - 1);
    }
    return $res;
}