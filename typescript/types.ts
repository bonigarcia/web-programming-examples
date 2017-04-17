// Basic types
let decimal: number = 6;
let done: boolean = false;
let color: string = "blue";

// Arrays
let list: number[] = [1, 2, 3];
let list: Array<number> = [1, 2, 3];

// Functions
let fun: Function = () => console.log("Hello");

// Expected return types
function returnNumber(): number {
   return 1;
}

// Void
function returnNothing(): void {
   console.log("Moo");
}

// Enums
enum Direction {
   Up,
   Down,
   Left,
   Right
}

let go: Direction;
go = Direction.Up;

// Class
let person: Person;
let people: Person[];

// Any
let notsure: any = 1;
