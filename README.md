# CS320
Repository for SNHU Class CS-320 (Software Test, Automation QA)


How can I ensure that my code, program, or software is functional and secure?

To ensure my code is functional, I write comprehensive unit tests that cover both expected inputs and edge cases, 
like I did with the Contact, Task, and Appointment services where I tested boundary values and invalid inputs. 
I also run all tests before committing any code changes to catch bugs early. 
For security, I implement input validation to prevent malicious data from entering the system and follow the principle of least privilege by only giving users access to what they need.

How do I interpret user needs and incorporate them into a program?

I interpret user needs by carefully reading the requirements and identifying the key constraints and business rules listed by the specific organization.
I break down vague requirements by asking clarifying questions and creating specific test cases that validate my understanding 
- for example, if a requirement says "name cannot be too long," I need to determine the exact character limit.
I also think about how users will actually interact with the system, considering realistic scenarios to account for what real users may input.
By translating requirements into concrete test cases first, I ensure that the code I write directly addresses what users need.

How do I approach designing software?

I approach software design by starting with the requirements and identifying the core objects and their relationships.
I keep the design simple and modular, following principles like single responsibility - each class has one clear purpose and each method does one thing. 
I also design with testing in mind, ensuring that classes are loosely coupled so they can be tested independently.
This upfront planning helps me write cleaner code and avoid having to make major structural changes later when requirements evolve or bugs are discovered.
