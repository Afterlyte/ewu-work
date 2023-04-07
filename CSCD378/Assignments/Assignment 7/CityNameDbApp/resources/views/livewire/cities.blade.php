<div>
    <input wire:model="search" type="text" placeholder="Search Cities">
    <table class="table table-striped table-hover">
        <tr>
            <th id="name">
                <a href="#" wire:click="sort('name', 'asc')">
                    <em class="icon icon-arrow-up"></em></a> Name 
                <a href="#" wire:click="sort('name', 'desc')">
                    <em class="icon icon-arrow-down"></em></a>
            </th>
            <th id="state">
                <a href="#" wire:click="sort('state', 'asc')">
                    <em class="icon icon-arrow-up"></em></a> State 
                <a href="#" wire:click="sort('state', 'desc')">
                    <em class="icon icon-arrow-down"></em></a>
            </th>
            <th id="2010pop">
                <a href="#" wire:click="sort('population_2010', 'asc')">
                    <em class="icon icon-arrow-up"></em></a> 2010 Pop. 
                <a href="#" wire:click="sort('population_2010', 'desc')">
                    <em class="icon icon-arrow-down"></em></a>
            </th>
            <th id="rank">
                <a href="#" wire:click="sort('population_rank', 'asc')">
                    <em class="icon icon-arrow-up"></em></a> Pop. Rank 
                <a href="#" wire:click="sort('population_rank', 'desc')">
                    <em class="icon icon-arrow-down"></em></a>
            </th>
        </tr>
        @foreach($cities as $city)
        <tr>
            <td>{{$city->name}}</td>
            <td>{{$city->state}}</td>
            <td>{{$city->population_2010}}</td>
            <td>{{$city->population_rank}}</td>
        </tr>
        @endforeach
    </table>
</div>