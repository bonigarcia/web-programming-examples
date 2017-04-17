interface Human {
   firstName: string;
   lastName: string;
   name?: Function;
   isLate?(time: Date): Function;
}

class Person implements Human {
   constructor(public firstName, public lastName) {
   }

   public name() {
     return `${this.firstName} ${this.lastName}`;
   }

   protected whoAreYou() {
     return `Hi i'm ${this.name()}`;
   }
}

let john = new Student("John", "Doe");
console.log(john.whoAreYou());
