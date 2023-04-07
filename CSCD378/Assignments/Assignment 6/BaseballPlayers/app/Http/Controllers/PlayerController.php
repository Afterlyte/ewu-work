<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Player;

class PlayerController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {
        $sort = $request->input('sort');
        if($sort == 'age') {
            $players = Player::orderBy('age', 'desc')->paginate(25);
        } else if($sort == 'position') {
            $players = Player::orderByRaw(
                '(case position
                    when "P" then 1
                    when "C" then 2
                    when "1B" then 3
                    when "2B" then 4
                    when "3B" then 5
                    when "SS" then 6
                    when "LF" then 7
                    when "CF" then 8
                    when "RF" then 9 end)'
            )->paginate(25);
        } else if($sort != null) {
            $players = Player::orderBy($sort, 'asc')->paginate(25);
        } else {
            $players = Player::paginate(25);
        }
        return view('players.index', ['players'=>$players]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $player = new \App\Models\Player;
        return view('players.create', ['player'=>$player]);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $validatedData = $this->validateData($request);
        \App\Models\Player::create($validatedData);
        return redirect()->route('players.index')->with('success', 'Player added successfully');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $player = \App\Models\Player::find($id);
        return view('players.show', ['player'=>$player]);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $player = \App\Models\Player::find($id);
        return view('players.edit', ['player'=>$player]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $validatedData = $this->validateData($request);
        \App\Models\Player::find($id)->update($validatedData);
        return redirect()->route('players.index')->with('success', 'Player updated successfully');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $player = \App\Models\Player::find($id);
        $name = $player->firstName." ".$player->lastName;
        $player->delete();
        return redirect()->route('players.index')->with('success', "$name was deleted successfully");
    }

    private function validateData($request) {
        return $request->validate(['firstName'=>'required', 'lastName'=>'required', 'team'=>'required', 'jerseyNumber'=>'required', 'position'=>'required', 'age'=>'integer|required']);
    }
}
