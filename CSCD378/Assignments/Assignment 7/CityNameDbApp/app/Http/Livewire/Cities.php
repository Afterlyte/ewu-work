<?php

namespace App\Http\Livewire;

use Livewire\Component;

class Cities extends Component
{
    public $search = "";
    protected $queryString = ['search'=>['except'=>''], 'sort'=>['except'=>''], 'direction'=>['except'=>'']];
    public $sort = 'name';
    public $direction = 'asc';

    public function render()
    {
        $cities = \App\Models\City::where('name', 'like', "%$this->search%")
            ->orWhere('state', 'like', "%$this->search%")
            ->orderBy($this->sort, $this->direction);
        return view('livewire.cities', ['cities'=>$cities->get()]);
    }

    public function sort($field, $dir) {
        $this->sort = $field;
        $this->direction = $dir;
    }
}
