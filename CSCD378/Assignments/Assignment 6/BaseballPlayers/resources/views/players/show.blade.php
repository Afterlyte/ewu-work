@extends('layout')

@section('content')
    <h2>Player Details</h2>
    @if($errors->any())
        <div class="toast toast-error">
            @foreach($errors->all() as $error)
                <span>{{$error}}</span>
            @endforeach
        </div>
    @endif
    <div class="tile column col-5" style="border:1px solid black; padding:10px">
        <div class="tile-content">
            <h5 class="tile-title">{{$player->firstName." ".$player->lastName}}</h5>
            <p class="tile-subtitle">Team: {{$player->team}}</p>
            <p class="tile-subtitle">Jersey: {{$player->jerseyNumber}}</p>
            <p class="tile-subtitle">Position: {{$player->position}}</p>
            <p class="tile-subtitle">Age: {{$player->age}}</p>
        </div>
        <div class="tile-action">
            <form action="{{route('players.destroy', $player->id)}}" method="POST" onsubmit="return confirm('Are you sure you want to delete {{$player->firstName}} {{$player->lastName}}?');">
                @csrf
                <a class="btn" href="{{route('players.edit', $player->id)}}">Edit</a>
                @method('DELETE')
                <button class="btn btn-error" type="submit">Delete</button>
            </form>
        </div>
    </div>
    <div style="padding-top:10px">
        <a class="btn" href="{{route('players.index')}}">Go Back</a>
    </div>
@endsection