# Encapsulation

The Elevator class.


## Note

- An X in the set column indicates the property must have a `set`.

## Lecture exercise

### Step Six: Implement the `Elevator` class

#### Instance variables

| Attribute      | Data Type | Get | Set | Description                                     |
| -------------- | --------- | --- | --- | ----------------------------------------------- |
| elevatorTag    | String          | X   |   X  | The tag/id used for the elevator inspection.      |
| currentFloor   | int       | X   |     | The current floor that the elevator is on.      |
| numberOfFloors | int       | X   |     | The number of floors available to the elevator. |
| doorOpen       | boolean   | X   |     | Whether the elevator door is open or not.       |

#### Constructor

The `Elevator` class has a single constructor that accepts two parameter, `String elevatorTag and int numberOfLevels`, which indicates how many floors are available to the elevator.

Either provide a default value or set it in the constructor so new elevators start on floor one.

#### Methods

Create methods based on the following signatures:

```
    void openDoor()
    void closeDoor()
    void goUp(int desiredFloor)
    void goDown(int desiredFloor)
```

**Acceptance criteria**

- `openDoor()` opens the elevator door.
- `closeDoor()` closes the elevator door.
- `goUp(int desiredFloor)` sends the elevator upward to the desired floor as long as the door isn't open. The elevator can't go past the last floor.
- `goDown(int desiredFloor)` sends the elevator downward to the desired floor as long as the door isn't open. It can't go past floor one.

---


