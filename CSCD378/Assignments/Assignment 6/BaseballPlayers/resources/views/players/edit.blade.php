@extends('layout')

@section('content')
    <div class="column col-4">
        <h2>Update Player</h2>
        @if($errors->any())
        <div class="toast toast-error">
            @foreach($errors->all() as $error)
                <span>{{$error}}</span>
            @endforeach
        </div>
        @endif
        <form method="POST" action="{{route('players.update', $player->id)}}">
        @csrf
        @method("PUT")
        @include('players.form')
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="{{route('players.index')}}">Cancel</a>
        </div>
@endsection