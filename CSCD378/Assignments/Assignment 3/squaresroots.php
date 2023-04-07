<h1 style="background-color:white">Squares and Roots</h1>
<h2 style="text-align:left; padding-left:0">Here's some quick math for you!</h2>
<p><strong><?php echo $num ?> squared is <?php squared($num) ?>, and <?php echo $num ?> cubed is <?php cubed($num) ?></strong></p>
<br>
<h2 style="text-align:left; padding-left:0">Now for some roots</h2>
<p><strong>The square root of <?php echo $num ?> is <?php squareRoot($num) ?>, and the cube root of <?php echo $num ?> is <?php cubeRoot($num) ?></strong></p>

<?php
/**
 * Ian Kaiserman
 * Assignment 3: Fun With Integers
 * PHP file for calling and displaying functions and HTML related to the Squares And Roots info
 */

function squared($num) {
    echo pow($num, 2);
}
function cubed($num) {
    echo pow($num, 3), '<br>';
}
function squareRoot($num) {
    echo round(pow($num, 1/2), 4);
}
function cubeRoot($num) {
    echo round(pow($num, 1/3), 4), '<br>';
}