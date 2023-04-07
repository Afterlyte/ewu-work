@extends('layout')

@section('content')
    <div class="column col-4">
        <h2>Add Player</h2>
        @if($errors->any())
        <div class="toast toast-error">
            @foreach($errors->all() as $error)
                <span>{{$error}}</span>
            @endforeach
        </div>
        @endif
        <form method="POST" action="{{route('players.store')}}">
        @csrf
        @include('players.form')
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="{{route('players.index')}}">Cancel</a>
        </div>
@endsection