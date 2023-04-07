<!DOCTYPE html>
<html lang="en-us">
    <head>
        <title>Baseball Players</title>
        <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
        <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
        <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
    </head>

    <body>
        <div class="container">
            <h1>Baseball Players Database</h1>
            @if(session()->get('success'))
            <div class="toast toast-success">
                {{session()->get('success')}}
            </div>
            @endif
            @yield('content')
        </div>
    </body>
</html>