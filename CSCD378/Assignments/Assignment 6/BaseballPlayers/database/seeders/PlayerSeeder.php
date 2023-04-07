<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use \App\Models\Player;

class PlayerSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        \App\Models\Player::query()->delete();
        $faker = \Faker\Factory::create();
        $positions = array("P", "C", "1B", "2B", "3B", "SS", "LF", "CF", "RF");
        foreach(range(1,100) as $number) {
            \App\Models\Player::create([
                'firstName'=>$faker->firstName,
                'lastName'=>$faker->lastName,
                'team'=>$faker->words(2, true),
                'jerseyNumber'=>$faker->bothify('##'),
                'position'=> $positions[rand(0, 8)],
                'age'=>$faker->numberBetween(18, 120)
            ]);
        }
    }
}
