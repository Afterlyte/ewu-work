<div class="form-group">
    <label class="form-label" for="name">First Name</label>
    <input class="form-input" type="text" name="firstName" id="firstName" value="{{old('firstName', $player->firstName)}}">
    <label class="form-label" for="name">Last Name</label>
    <input class="form-input" type="text" name="lastName" id="lastName" value="{{old('lastName', $player->lastName)}}">
    <label class="form-label" for="name">Team</label>
    <input class="form-input" type="text" name="team" id="team" value="{{old('team', $player->team)}}">
    <label class="form-label" for="name">Jersey #</label>
    <input class="form-input" type="text" size="2" maxlength="2" name="jerseyNumber" id="jerseyNumber" value="{{old('jerseyNumber', $player->jerseyNumber)}}">
    <label class="form-label" for="name">Position</label>
    <select class="form-select" name="position">
        <option value="P">Pitcher</option>
        <option value="C">Catcher</option>
        <option value="1B">First Base</option>
        <option value="2B">Second Base</option>
        <option value="3B">Third Base</option>
        <option value="SS">Short Stop</option>
        <option value="LF">Left Field</option>
        <option value="CF">Center Field</option>
        <option value="RF">Right Field</option>
    </select>
    <label class="form-label" for="name">Age</label>
    <input class="form-input" type="number" name="age" id="age" min="0" max="120" value="{{old('age', $player->age)}}">
</div>