I do not know how to properly document changes or my code here yet, so this will have to do.

Overall Structure:
Ultimate Tic Tac Toe is based on Winnable objects contained within Winnable objects. For example,
the Ultimate Tic Tac Toe board depends on 9 individual normal Tic Tac Toe boards. The individual normal
Tic Tac Toe board depends on 9 individual point cell objets.

Winnable class:
The Ultimate Tic Tac Toe program depends on the Winnable class. The Winnable class is a
representation for multiple game elements. For example, the class represents tic tac toe
cells, tic tac toe boards, and the Ultimate Tic Tac Toe board. The Winnable class as a result
has a method to check for whether any tic tac toe related board of any size is won. The 
most paradoxical element of the Winnable class is that it contains an array of Winnable objects,
but this allows the Winnable class to check whether any instance is won by using this array. 
Unfortunately, this makes direct instances of the Winnable class unusable, as the Winnable 
array never has its elements initialized in the Winnable class (i.e. there would otherwise 
be infinite initialization of Winnable objects).

Point class:
In hindsight, this class should have been named cell, but refactoring so many classes would be risky.
In addition, I thought at the time that cell would be ambiguous (cell of the entire board, cell 
of a single board?) The Point class represents an individual cell in a simple tic-tac-toe board.
The Point class does not depend on an instance of Winnable array, and instead overrides the Winnable isWon
method to check whether or not the individual cell is filled or not.

NormalBoard:
This is a board with a 2 dimensional array of Point elements. The NormalBoard takes a constructor of one argument,
integer, which tells how big the NormalBoard must be. Because Point is an array of Winnables, it can use the same
algorithm inherited from the Winnable superclass to run the isWon method.

UltimateBoard:
This is a board with a 2 dimensional array of NormalBoard elements. The UltimateBoard takes a constructor of one argument
and uses it to choose how big the 2 dimensional array of NormalBoard elements will be, as well as for the argument for
each NormalBoard object.

JPoint:
Extends the Point class and uses JButton from Swing package to add a GUI element.

JNormalBoard:
Extends the NormalBoard class and contains a 2 dimensional array of JPoint elements

JUltimateBoard:
Extends the UltimateBoard class and contains a 2 dimensional array of JNormalBoard objects

UltimateTicTacToe:
This class runs the Ultimate Tic Tac Toe game and GUI. The class includes a commented out previous version
of Ultimate Tic Tac Toe which ran on command line.