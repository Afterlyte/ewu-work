<h1>Cities List</h1>

@foreach($cities as $city)
    <h2>{{$city->name}}</h2>
    <ul>
        <li>State: {{$city->state}}</li>
        <li>2010 Population: {{$city->population_2010}}</li>
        <li>Population Rank: {{$city->population_rank}}</li>
    </ul>
@endforeach