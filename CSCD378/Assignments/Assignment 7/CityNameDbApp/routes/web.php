<?php
/**
 * Ian Kaiserman
 * CSCD 378
 * Assignment 7: LiveWire
 * Laravel project that iterates through data on various cities and displays them via HTML/PHP
 * This project has been modified from the original submission for Assignment 5 to implement Livewire for searching/sorting capabilities
 */
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', App\Http\Livewire\Cities::class);