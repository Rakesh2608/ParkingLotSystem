Q1.In controller inputs should be
one parameter or multiple parameters?
ans:-Always wiser to use one parameter as the requirements may change in 
future and our order of parameters may wrongly assign. It is better for future modification.
One parameter(One requestDTO which has all input fields in it)

Q2.Instead of DTO can't we use modals for input in controllers?
ans:-1 necessary information => no modal has all input together
models has SRP of representing schema of a problem.

Q3.Instead of DTO can't we use modals for output in controllers?
ans:-No same reasons as above.


Pain point in ParkingLot
1.Getters and Setters
2.No real DB.
3.Dependency Injection.





