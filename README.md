BUGS(for now):

The default size of the window needs work, since it occasionally varies 
enough to become a 8 by 12 game. Please resize.

Also, pardon the unlabeled rows, columns, cells, supercells, etc.

Instructions:
Unfortunately, I need to work on integrating instructions into my game. 
However, a simple explanation will do finely for now.

Ultimate Tic Tac Toe is a game comprised of 9 individual Tic Tac Toe games
arranged in a three by three grid. The original variant of the game requires
a player to win three individual games in the larger grid in order to win.

However, a player cannot usually play on any individual board he or she wants.
The player can only play on a corresponding individual board based on the
cell that the opponent played.

For example, Player 1 plays on turn 1 in supercell row 1, column 2, 
cell row 3, column 3. On turn 2, Player 2 can play in supercell row
3 and column 3. Player 2 plays on cell row 2, column 1. As a result,
Player 1 can only play on supercell row 2, column 1 on turn 3, etc.

The only exception to this rule is on turn 1, or whenever the previous
players choice leads to a filled or finished board. Then the player has
a choice in any supercell. For example, Player 1 may play in cell column
1, row 2. Supercell column 1, row 2 is finished (i.e. though Player 2 may
place his mark there, the individual board is already won). Therefore 
Player 2 may play anywhere.

A good strategy is to try to control the opponent to prevent him from 
winning individual boards or gaining free moves to any supercell, 
while still filling out the board.