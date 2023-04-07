@extends('layout')

@section('content')
    <h2>Players Index</h2>
    <a class="btn btn-primary" href="{{route('players.create')}}">Add Player</a>
    <table class="table table-striped table-hover">
        <caption><h3>Current Players</h3></caption>
        {{$players->withQueryString()->links()}}
        <tr>
            <th id="firstName"><a href="{{route('players.index', ['sort'=>'firstName'])}}">First Name</a></th>
            <th id="lastName"><a href="{{route('players.index', ['sort'=>'lastName'])}}">Last Name</a></th>
            <th id="team"><a href="{{route('players.index', ['sort'=>'team'])}}">Team</a></th>
            <th id="jerseyNumber">Jersey</th>
            <th id="position"><a href="{{route('players.index', ['sort'=>'position'])}}">Position</a></th>
            <th id="age"><a href="{{route('players.index', ['sort'=>'age'])}}">Age</a></th>
            <th id="details"></th>
            <th id="edit"></th>
            <th id="delete"></th>
        </tr>
        @foreach($players as $player)
        <tr>
            <td>{{$player->firstName}}</td>
            <td>{{$player->lastName}}</td>
            <td>{{$player->team}}</td>
            <td>{{$player->jerseyNumber}}</td>
            <td>{{$player->position}}</td>
            <td>{{$player->age}}</td>
            <td><a class="btn btn-sm" href="{{route('players.show', $player->id)}}">Show Details</a></td>
            <td><a class="btn btn-sm" href="{{route('players.edit', $player->id)}}">Edit</a></td>
            <td>
                <form action="{{route('players.destroy', $player->id)}}" method="POST" onSubmit="return confirm('Are you sure you want to delete {{$player->firstName}} {{$player->lastName}}?');">
                    @csrf
                    @method('DELETE')
                    <button class="btn btn-error btn-sm" type="submit">Delete</button>
                </form>
            </td>
        </tr>
        @endforeach
    </table>
    {{$players->withQueryString()->links()}}
@endsection