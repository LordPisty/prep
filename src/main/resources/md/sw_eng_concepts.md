### sw eng concepts

* **abstraction** (Interfaces) represent meaningful features of an entity, hiding useless details
* **encapsulation** (Classes) wrapping data and behavior of an object into a single unit
  * information/data hiding ? modifiers
  * changes to one module do not affect another
* **Object**
  * state (data)
  * behavior (code)
* **OOP**
  * **abstraction**
  * **dynamic dispatch** when a method is invoked on an object, the object itself determines what code gets executed by        looking up the method at run time in a table associated with the object. This feature distinguishes an object from an        abstract data type (or module), which has a fixed (static) implementation of the operations for all instances. It is a      programming methodology that gives modular component development while at the same time being very efficient.
  * **encapsulation**
  * **subtype polymorphism** one object can take many form
    * parent class reference for child class object
    * different behavior in different instances
    * behavior depends on actual runtime types
  * **inheritance** object of one class acquire properties of an other class
    * hierarchical classification
    * reuse
    * object/class is based on another object/class

---
* **sub-typing** is-a relationship
  * interface inheritance
  * inheritance reuses implementation: implementation/code inheritance
* **composition** has-a relationship

---
* **concurrency** is a property of systems in which several computations are executing simultaneously, and potentially interacting with each other. The computations may be executing on multiple cores in the same chip, preemptively time-shared threads on the same processor, or executed on physically separated processors

---
* **method signature** name + parameters
* **overloading** compile time
  * same name, different parameters
    * number
    * types
  * static methods can be overloaded
  * static binding
  * private/final can be overloaded
  * return type should be the same
* **overriding** runtime
  * method redefined in derived class
  * same name, parameters, return type
  * static methods cannot be overridden
  * dynamic binding
  * private/final cannot be overridden
  * return type can be subclass (covariant)