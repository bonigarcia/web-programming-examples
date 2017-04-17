function Student(config) {
   return function (target) {
      Object.defineProperty(target.prototype, 'course', {value: () => config.course})
   }
}

@Student({
   course: "angular3"
})
class Person {
   constructor(private firstName, private lastName) {
   }

   public name() {
      return `${this.firstName} ${this.lastName}`;
   }

   protected whoAreYou() {
     return `Hi i'm ${this.name()}`;
   }
}

let john = new Person("John", "Doe");
console.log(john.whoAreYou());
