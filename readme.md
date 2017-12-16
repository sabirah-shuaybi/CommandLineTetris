Sabirah Shuaybi

The purpose of this readme file is to provide an
explanation for the different approach I took when coding
Tetris as well as to document some additional features that were added.

In this implementation of the game Tetris, no separate board class
is needed. This is because all a board contains (in this particular interface)
is the shapes that have landed (and thus are locked down) and the shape that is
currently falling. Thus, to simulate a board, the data structure Sets 
(containing Cell objects) are used(implementation: HashSets). 
Throughout the game, as shapes land, their Cells are added to the set of 
lockedCells - which are a collection of all the locked/occupied Cell currently 
in the game. The second set maintains the Cells of the shape that 
is currently falling.

The reason for using Sets rather than a traditional Board class is because
adding to and removing values from a set are very easy to achieve. Furthermore,
a set contains only unique values (no duplicates). This makes sense in the case 
of Tetris because all Cells on the grid are unique - there can only be one of each 
location. Also, collision detection becomes easy as well since you can just 
compare the two sets (lockedCells and fallingShapeCells) and determine if any
Cells in one set coincide with the ones in the other set (this is exactly what the 
intersects() function does in TetrisUtil). 

Inheritance was not used in this implementation (in terms of each individual 
Tetris piece as its own sub class that extends from parent class Shape). 
Instead, I created all of the shapes in the class TetrisShapeFactory to make 
the code more compact and to avoid having to make a separate class for 
each of the seven shapes. 

LASTLY, to make testing and playing the game more efficient, I added a DROP option
for the user. In addtion to the main actions (down, left, right, CW, CWW), I thought
it would be useful to have a way of simply arranging the shape where you want it,
horizontally, and then entering "p" for drop and it drops all the way to the bottom,
or until it lands on another piece. Because the drop will happen to fast for human
eyes to perceive, I added a sleep method in TetrisUtil, which puts the thread to 
sleep for a given number of milliseconds. This creates the illusion of the shape
actually 'dropping' down. 