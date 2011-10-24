package roart.pacman.game;

import java.awt.Point;
import java.util.Iterator;

import roart.pacman.unit.Element;
import roart.pacman.unit.DynamicElement;

//#define initen {0}

//the following is the list structure for the DynamicElements, the sprites.
//it includes a pointer to the element, what graphical id it has
//the coordinates and a pointer to the next element of the structure

public class Board {

    //static Element board[Sizes.BOARDWIDTH][Sizes.BOARDHEIGHT];	//matrix pointer to elements

    //the graphical elements of the board
    //CHECKSTYLE:OFF
	/*
	 * CHECKSTYLE:OFF
	 */
    private static String[][][] boards/*[Pacman.LEVELS][Sizes.BOARDHEIGHT+1][Sizes.BOARDWIDTH+1]*/=
    {{{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . .O. . . . . . . .O. . . oO"},
      {"O OOOOO O OOOOOOOOOOOOO O OOOOO O"},
      {"O.O. . . . . . . . . . . . . .O.O"},
      {"O O O O OOO OOOOOOOOO OOO O O O O"},
      {"O. .O.O. . . . . . . . . .O.O. .O"},
      {"OOO O O OOOOO OOOOO OOOOO O O OOO"},
      {"O. .O. . . .O. . . .O. . . .O. .O"},
      {"O O O OOOOO O O___O O OOOOO O O O"},
      {"O.O. . . .O.O.O   O.O.O. . . .O.O"},
      {"O O OOOOO O O O   O O O OOOOO O O"},
      {"O.O. . . .O.O.O   O.O.O. . . .O.O"},
      {"O OOO O O O O OOOOO O O O O OOO O"},
      {"O. . .O.O. . . . . . . .O.O. . .O"},
      {"O OOOOO O O OOOOOOOOO O O OOOOO O"},
      {"O. . . . .O. . . . . .O. . . . .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"O. .O. . . . . . . . . . . .O. .O"},
      {"OOO O OOO O OOOOOOOOO O OOO O OOO"},
      {"O. .O. . .O. . . . . .O. . .O. .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"Oo . . . .O. . . . . .O. . . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . .O. . . . . . . .O. . . oO"},
      {"O OOOOO O O OOOOOOOOO O O OOOOO O"},
      {"O.O. .O. .O. . . . . .O. .O. .O.O"},
      {"O O O O OOO OOO O OOO OOO O O O O"},
      {"O. .O.O. . . . .O. . . . .O.O. .O"},
      {"OOO O O O OOO OOOOO OOO O O O OOO"},
      {"O. .O. .O. .O. . . .O. .O. .O. .O"},
      {"O OOOOO O O O O___O O O O OOOOO O"},
      {"O.O. . . .O.O.O   O.O.O. . . .O.O"},
      {"O O OOOOO O O O   O O O OOOOO O O"},
      {"O.O. . . .O.O.O   O.O.O. . . .O.O"},
      {"O OOO O O O O OOOOO O O O O OOO O"},
      {"O. . .O.O. . . . . . . .O.O. . .O"},
      {"OOOOOOO O O OOOOOOOOO O O OOOOOOO"},
      {"O. . . . .O. . . . . .O. . . . .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"O. .O. . . . . . . . . . . .O. .O"},
      {"OOO O OOO O OOOOOOOOO O OOO O OOO"},
      {"O. .O. . .O. . . . . .O. . .O. .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"Oo . . . .O. . . . . .O. . . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . .O. . . . . . . .O. . . oO"},
      {"O OOOOO O OOOOO O OOOOO O OOOOO O"},
      {"O.O. .O. . . . .O. . . . .O. .O.O"},
      {"O O O OOOOOOO O O O OOOOOOO O O O"},
      {"O. .O.O. . . .O. .O. . . .O.O. .O"},
      {"OOO O O O OOO OOOOO OOO O O O OOO"},
      {"O. .O. .O. . . . . . . .O. .O. .O"},
      {"O O OOO OOO O O___O O OOO OOO O O"},
      {"O.O. . . .O.O.O   O.O.O. . . .O.O"},
      {"O O OOOOO O O O   O O O OOOOO O O"},
      {"O.O. . . .O.O.O   O.O.O. . . .O.O"},
      {"O OOO O O O O OOOOO O O O O OOO O"},
      {"O. . .O.O. . . . . . . .O.O. . .O"},
      {"O OOOOO O O OOOOOOOOO O O OOOOO O"},
      {"O. . . . .O. . . . . .O. . . . .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"O. .O. . .O. . . . . .O. . .O. .O"},
      {"OOO O OOO O OOOOOOOOO O OOO O OOO"},
      {"O. .O. . .O. . . . . .O. . .O. .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"Oo . . . .O. . . . . .O. . . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . .O. . . . . . . .O. . . oO"},
      {"O OOOOO O O OOOOOOOOO O O OOOOO O"},
      {"O.O. .O. .O. . .O. . .O. .O. .O.O"},
      {"O O O O OOOOO O O O OOOOO O O O O"},
      {"O. .O.O. . . .O. .O. . . .O.O. .O"},
      {"OOO O O OOOOO OOOOO OOOOO O O OOO"},
      {"O. .O. . . .O. . . .O. . . .O. .O"},
      {"O OOO OOOOO O O___O O OOOOO OOO O"},
      {"O.O. . . .O.O.O   O.O.O. . . .O.O"},
      {"O O OOOOO O O O   O O O OOOOO O O"},
      {"O.O.O. . .O.O.O   O.O.O. . .O.O.O"},
      {"O O O O O O O OOOOO O O O O O O O"},
      {"O.O. .O.O. . . . . . . .O.O. .O.O"},
      {"O OOOOO O O OOOOOOOOO O O OOOOO O"},
      {"O. . . . .O. . . . . .O. . . . .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"O. .O. . . . . . . . . . . .O. .O"},
      {"OOO O OOOOO OOOOOOOOO OOOOO O OOO"},
      {"O. .O. . .O. . . . . .O. . .O. .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"Oo . . . .O. . . . . .O. . . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . .O. . . .O. . . .O. . . oO"},
      {"O OOOOO O O OOO O OOO O O OOOOO O"},
      {"O.O. .O. .O. . .O. . .O. .O. .O.O"},
      {"O O O OOOOOOO O O O OOOOOOO O O O"},
      {"O. .O. . . . .O. .O. . . . .O. .O"},
      {"OOO O O OOOOO OOOOO OOOOO O O OOO"},
      {"O. .O.O. . .O. . . .O. . .O.O. .O"},
      {"O OOO OOOOO O O___O O OOOOO OOO O"},
      {"O. . . . .O.O.O   O.O.O. . . . .O"},
      {"O OOOOOOO O O O   O O O OOOOOOO O"},
      {"O. .O. . .O.O.O   O.O.O. . .O. .O"},
      {"O O O O O O O OOOOO O O O O O O O"},
      {"O.O. .O.O. . . .O. . . .O.O. .O.O"},
      {"O OOOOO O O OOO O OOO O O OOOOO O"},
      {"O. . . . .O.O. . . .O.O. . . . .O"},
      {"O OOOOOOO O O OOOOO O O OOOOOOO O"},
      {"O. .O. . . .O. . . .O. . . .O. .O"},
      {"OOO O OOOOOOO OOOOO OOOOOOO O OOO"},
      {"O. .O. . . .O. .O. .O. . . .O. .O"},
      {"O OOOOOOO O OOO O OOO O OOOOOOO O"},
      {"Oo . . . .O. . .O. . .O. . . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . .O. . . . . . . .O. . . oO"},
      {"O OOOOO O O O OOOOO O O O OOOOO O"},
      {"O.O. .O. .O.O. .O. .O.O. .O. .O.O"},
      {"O O O OOOOO O O O O O OOOOO O O O"},
      {"O. .O.O. . . .O.O.O. . . .O.O. .O"},
      {"OOO O O OOOOO O O O OOOOO O O OOO"},
      {"O. .O.O. . . .O. .O. . . .O.O. .O"},
      {"O OOO O OOO O O___O O OOO O OOO O"},
      {"O. . . . .O.O.O   O.O.O. . . . .O"},
      {"O OOOOOOO O O O   O O O OOOOOOO O"},
      {"O. .O. . .O.O.O   O.O.O. . .O. .O"},
      {"O O O O O O O OOOOO O O O O O O O"},
      {"O.O. .O.O. .O. .O. .O. .O.O. .O.O"},
      {"O OOOOO OOO OOO O OOO OOO OOOOO O"},
      {"O.O. . . .O. . . . . .O. . . .O.O"},
      {"O O OOOOO O O OOOOO O O OOOOO O O"},
      {"O. . . . . .O. . . .O. . . . . .O"},
      {"OOOOOOO O OOO OOOOO OOO O OOOOOOO"},
      {"O. . . .O. . . .O. . . .O. . . .O"},
      {"O OOOOO O OOOOO O OOOOO O OOOOO O"},
      {"Oo . . .O. . . .O. . . .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . .O. . . . . . . .O. . . oO"},
      {"O OOOOO O OOOOOOOOOOOOO O OOOOO O"},
      {"O.O. .O. .O. . .O. . .O. .O. .O.O"},
      {"O O O OOOOO O O O O O OOOOO O O O"},
      {"O. .O.O. . .O.O. .O.O. . .O.O. .O"},
      {"OOOOO O OOOOO OOOOO OOOOO O OOOOO"},
      {"O. . .O. . .O. . . .O. . .O. . .O"},
      {"O OOO O OOO O O___O O OOO O OOO O"},
      {"O. . . . .O.O.O   O.O.O. . . . .O"},
      {"OOOOOOOOO O O O   O O O OOOOOOOOO"},
      {"O. . . .O.O.O.O   O.O.O.O. . . .O"},
      {"O O OOO O O O OOOOO O O O OOO O O"},
      {"O.O. .O. . .O. .O. .O. . .O. .O.O"},
      {"O OOO OOOOO OOO O OOO OOOOO OOO O"},
      {"O.O. . . .O. . . . . .O. . . .O.O"},
      {"O O OOOOO O O OOOOO O O OOOOO O O"},
      {"O. .O. . . .O. . . .O. . . .O. .O"},
      {"OOOOO O O OOO OOOOO OOO O O OOOOO"},
      {"O. . .O.O. . . .O. . . .O.O. . .O"},
      {"O OOOOO O OOOOO O OOOOO O OOOOO O"},
      {"Oo . . .O. . . .O. . . .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . .O. . . .O. . . .O. . . oO"},
      {"O OOOOO O O OOO O OOO O O OOOOO O"},
      {"O.O. .O. .O. . .O. . .O. .O. .O.O"},
      {"O O O OOOOO O O O O O OOOOO O O O"},
      {"O. .O.O. . .O.O. .O.O. . .O.O. .O"},
      {"OOOOO O OOOOO OOOOO OOOOO O OOOOO"},
      {"O. . .O. . .O. . . .O. . .O. . .O"},
      {"O OOO O OOO O O___O O OOO O OOO O"},
      {"O. . . . .O.O.O   O.O.O. . . . .O"},
      {"OOOOOOOOO O O O   O O O OOOOOOOOO"},
      {"O. . . .O.O.O.O   O.O.O.O. . . .O"},
      {"O O OOO O O O OOOOO O O O OOO O O"},
      {"O.O. .O. . .O. .O. .O. . .O. .O.O"},
      {"O OOO OOOOO OOO O OOO OOOOO OOO O"},
      {"O.O. . . .O. . . . . .O. . . .O.O"},
      {"O O OOOOO O O OOOOO O O OOOOO O O"},
      {"O. .O. . . .O. . . .O. . . .O. .O"},
      {"OOOOO O O OOO OOOOO OOO O O OOOOO"},
      {"O. . .O.O. . . .O. . . .O.O. . .O"},
      {"O OOOOO O OOOOO O OOOOO O OOOOO O"},
      {"Oo . . .O. . . .O. . . .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . . . . . . . . . . . . . oO"},
      {"O O OOOOOOOOOOOOOOOOOOOOOOOOO O O"},
      {"O.O. .O. . . . .O. . . . .O. .O.O"},
      {"O O O O OOO O O O O O OOO O O O O"},
      {"O. .O.O. . .O.O. .O.O. . .O.O. .O"},
      {"OOO O O OOOOO OOOOO OOOOO O O OOO"},
      {"O. .O.O. . .O. . . .O. . .O.O. .O"},
      {"O OOO O OOO O O___O O OOO O OOO O"},
      {"O. . .O. .O.O.O   O.O.O. .O. . .O"},
      {"O OOO OOO O O O   O O O OOO OOO O"},
      {"O. .O. .O.O.O.O   O.O.O.O. .O. .O"},
      {"O O OOO O O O OOOOO O O O OOO O O"},
      {"O.O. .O. . .O. .O. .O. . .O. .O.O"},
      {"O OOO OOOOO OOO O OOO OOOOO OOO O"},
      {"O. . . . .O. . . . . .O. . . . .O"},
      {"O OOOOOOO O OOOOOOOOO O OOOOOOO O"},
      {"O. .O. . .O. . . . . .O. . .O. .O"},
      {"OOO O O O O OOOOOOOOO O O O O OOO"},
      {"O. . .O.O.O. .O. .O. .O.O.O. . .O"},
      {"O OOOOO O O O O O O O O O OOOOO O"},
      {"Oo . . .O. .O. .O. .O. .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . . .O. . . . . .O. . . . oO"},
      {"O OOOOO O O O O O O O O O OOOOO O"},
      {"O.O. .O.O. .O.O.O.O.O. .O.O. .O.O"},
      {"O O O O OOO O O O O O OOO O O O O"},
      {"O. .O.O. . .O.O. .O.O. . .O.O. .O"},
      {"OOO O O OOOOO OOOOO OOOOO O O OOO"},
      {"O. .O.O. . .O. . . .O. . .O.O. .O"},
      {"O OOO O OOO O O___O O OOO O OOO O"},
      {"O. . .O. .O.O.O   O.O.O. .O. . .O"},
      {"OOOOO OOO O O O   O O O OOO OOOOO"},
      {"O. .O. .O.O.O.O   O.O.O.O. .O. .O"},
      {"O O OOO O O O OOOOO O O O OOO O O"},
      {"O.O. .O.O. .O. .O. .O. . .O. .O.O"},
      {"O OOO O OOO OOO O OOO OOO O OOO O"},
      {"O.O. .O. .O. . . . . .O. .O. .O.O"},
      {"O O OOOOO O OOOOOOOOO O OOOOO O O"},
      {"O.O.O. . . . . . . . . . . .O.O.O"},
      {"O O O O O OOOOOOOOOOOOO O O O O O"},
      {"O.O. .O.O.O. .O. .O. .O.O.O. .O.O"},
      {"O OOOOO O O O O O O O O O OOOOO O"},
      {"Oo . . .O. .O. .O. .O. .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . . .O. . .O. . .O. . . . oO"},
      {"O OOOOO O O O O O O O O O OOOOO O"},
      {"O.O. . .O. .O.O.O.O.O. .O. . .O.O"},
      {"O O O OOOOOOO O O O OOOOOOO O O O"},
      {"O. .O.O. . . .O. .O. . . .O.O. .O"},
      {"OOO O O OOOOO OOOOO OOOOO O O OOO"},
      {"O. .O.O. . .O. . . .O. . .O.O. .O"},
      {"O OOO O OOO O O___O O OOO O OOO O"},
      {"O. . .O. .O.O.O   O.O.O. .O. . .O"},
      {"OOOOO OOO O O O   O O O OOO OOOOO"},
      {"O. .O. .O.O.O.O   O.O.O.O. .O. .O"},
      {"O O OOO O O O OOOOO O O O OOO O O"},
      {"O.O. .O.O.O. . . . . .O.O.O. .O.O"},
      {"O OOO O O O OOOOOOOOO O O O OOO O"},
      {"O.O. . .O.O. . . . . .O.O. . .O.O"},
      {"O O OOOOO O OOOOOOOOO O OOOOO O O"},
      {"O.O.O. . .O. . . . . .O. . .O.O.O"},
      {"O O O O O OOOOOOOOOOOOO O O O O O"},
      {"O.O. .O.O.O. .O. .O. .O.O.O. .O.O"},
      {"O OOOOO O O O O O O O O O OOOOO O"},
      {"Oo . . .O. .O. .O. .O. .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . . .O. . .O. . .O. . . . oO"},
      {"O OOOOO O O O O O O O O O OOOOO O"},
      {"O.O. . .O. .O.O.O.O.O. .O. . .O.O"},
      {"O O O OOOOOOO O O O OOOOOOO O O O"},
      {"O. .O.O. . . .O. .O. . . .O.O. .O"},
      {"OOOOO O OOOOO OOOOO OOOOO O OOOOO"},
      {"O. . .O. . .O. . . .O. . .O. . .O"},
      {"O OOO O OOO O O___O O OOO O OOO O"},
      {"O. . .O. .O.O.O   O.O.O. .O. . .O"},
      {"OOOOO OOO O O O   O O O OOO OOOOO"},
      {"O. .O. . .O.O.O   O.O.O. . .O. .O"},
      {"O O OOOOO O O OOOOO O O OOOOO O O"},
      {"O.O. .O. .O. . . . . .O. .O. .O.O"},
      {"O OOO O OOO OOOOOOOOO OOO O OOO O"},
      {"O. . . . .O. . . . . .O. . . . .O"},
      {"O O OOOOO O OOOOOOOOO O OOOOO O O"},
      {"O.O.O. . .O. . . . . .O. . .O.O.O"},
      {"O O O O O OOOOOOOOOOOOO O O O O O"},
      {"O.O. .O.O.O. .O. .O. .O.O.O. .O.O"},
      {"O OOOOO O O O O O O O O O OOOOO O"},
      {"Oo . . .O. .O. .O. .O. .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . . . .O. .O. .O. . . . . oO"},
      {"O OOOOOOOOO O O O O O OOOOOOOOO O"},
      {"O.O. .O. . . .O.O.O. . . .O. .O.O"},
      {"O O O O O O OOO O OOO O O O O O O"},
      {"O. .O. .O.O. . .O. . .O.O. .O. .O"},
      {"OOOOOOO O O O OOOOO O O O OOOOOOO"},
      {"O. . .O. .O.O. . . .O.O. .O. . .O"},
      {"O OOO OOO O O O___O O O OOO OOO O"},
      {"O. . .O. .O.O.O   O.O.O. .O. . .O"},
      {"OOOOO O O O O O   O O O O O OOOOO"},
      {"O. .O. .O.O.O.O   O.O.O.O. .O. .O"},
      {"O O OOOOO O O OOOOO O O OOOOO O O"},
      {"O.O. .O. .O.O. . . .O.O. .O. .O.O"},
      {"O OOO O OOO OOOOOOOOO OOO O OOO O"},
      {"O.O. .O. .O. . . . . .O. .O. .O.O"},
      {"O O OOO O O OOOOOOOOO O O OOO O O"},
      {"O.O.O. .O.O. . . . . .O.O. .O.O.O"},
      {"O O O O O OOOOOOOOOOOOO O O O O O"},
      {"O.O. .O.O.O. .O. .O. .O.O.O. .O.O"},
      {"O OOOOO O O O O O O O O O OOOOO O"},
      {"Oo . . .O. .O. .O. .O. .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . . . .O. .O. .O. . . . . oO"},
      {"O OOOOOOOOO O O O O O OOOOOOOOO O"},
      {"O.O. .O. . . .O.O.O. . . .O. .O.O"},
      {"O O O O OOOOOOO O OOOOOOO O O O O"},
      {"O. .O.O. . . .O. .O. . . .O.O. .O"},
      {"OOOOO O OOO O OOOOO O OOO O OOOOO"},
      {"O. . .O. .O.O. . . .O.O. .O. . .O"},
      {"O OOOOOOO O O O___O O O OOOOOOO O"},
      {"O. . .O. . .O.O   O.O. . .O. . .O"},
      {"OOOOO O OOOOO O   O OOOOO O OOOOO"},
      {"O. .O. . . .O.O   O.O. . . .O. .O"},
      {"O O O OOO O O OOOOO O O OOO O O O"},
      {"O.O. . . .O.O. . . .O.O. . . .O.O"},
      {"O OOOOO OOO OOOOOOOOO OOO OOOOO O"},
      {"O.O. .O. . . . . . . . . .O. .O.O"},
      {"O O O OOOOO OOOOOOOOO OOOOO O O O"},
      {"O.O.O. . .O. . . . . .O. . .O.O.O"},
      {"O O O OOO OOOOOOOOOOOOO OOO O O O"},
      {"O.O. . .O. . . . . . . .O. . .O.O"},
      {"O OOO O OOOOOOOOOOOOOOOOO O OOO O"},
      {"Oo . .O. . . . . . . . . .O. . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . . . .O. .O. .O. . . . . oO"},
      {"O OOOOOOOOO O O O O O OOOOOOOOO O"},
      {"O.O. .O. . . .O.O.O. . . .O. .O.O"},
      {"O O O O O O OOO O OOO O O O O O O"},
      {"O. .O. .O.O. . .O. . .O.O. .O. .O"},
      {"OOOOOOO O O O OOOOO O O O OOOOOOO"},
      {"O. . . . .O.O. . . .O.O. . . . .O"},
      {"O OOO OOO O O O___O O O OOO OOO O"},
      {"O. . .O. .O.O.O   O.O.O. .O. . .O"},
      {"OOOOOOO OOO O O   O O OOO OOOOOOO"},
      {"O. . .O. .O.O.O   O.O.O. .O. . .O"},
      {"O O O OOO O O OOOOO O O OOO O O O"},
      {"O.O.O.O. .O.O. . . .O.O. .O.O.O.O"},
      {"O O O O OOO OOOOOOOOO OOO O O O O"},
      {"O.O. .O. .O. . . . . .O. .O. .O.O"},
      {"O O OOOOO O OOOOOOOOO O OOOOO O O"},
      {"O.O.O. . .O. . . . . .O. . .O.O.O"},
      {"O O O OOO O OOOOOOOOO O OOO O O O"},
      {"O.O. . . .O. . . . . .O. . . .O.O"},
      {"O OOO O OOOOOOOOOOOOOOOOO O OOO O"},
      {"Oo . .O. . . . . . . . . .O. . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}},
     {{"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"},
      {"Oo . . . . .O. .O. .O. . . . . oO"},
      {"O OOOOOOOOO O O O O O OOOOOOOOO O"},
      {"O.O. . . . . .O.O.O. . . . . .O.O"},
      {"O O OOOOOOOOOOO O OOOOOOOOOOO O O"},
      {"O. . .O. . . .O. .O. . . .O. . .O"},
      {"OOOOO O OOOOO OOOOO OOOOO O OOOOO"},
      {"O. .O. . .O. . . . . .O. . .O. .O"},
      {"O O O OOO O O O___O O O OOO O O O"},
      {"O.O. .O. .O.O.O   O.O.O. .O. .O.O"},
      {"O OOO O O O O O   O O O O O OOO O"},
      {"O. . . .O. .O.O   O.O. .O. . . .O"},
      {"OOOOO OOOOOOO OOOOO OOOOOOO OOOOO"},
      {"O. . .O. . .O. . . .O. . .O. . .O"},
      {"O OOO O OOO OOOOOOOOO OOO O OOO O"},
      {"O.O. .O. .O. . . . . .O. .O. .O.O"},
      {"O O OOOOO O OOOOOOOOO O OOOOO O O"},
      {"O.O.O. . .O. . . . . .O. . .O.O.O"},
      {"O O O O OOOOOOOOOOOOOOOOO O O O O"},
      {"O.O. .O. . . . . . . . . .O. .O.O"},
      {"O OOOOO O OOOOOOOOOOOOO O OOOOO O"},
      {"Oo . . .O. . . . . . . .O. . . oO"},
      {"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"}}
    };
    //CHECKSTYLE:ON
/*
 * CHECKSTYLE:ON
 */

    private static Board instance= null; 	//initializers

    private java.util.ArrayList<BoardElement> curlist=new java.util.ArrayList<BoardElement>();
    private java.util.ArrayList<BoardElement> oldlist=new java.util.ArrayList<BoardElement>();
    //Element board[Sizes.BOARDWIDTH][Sizes.BOARDHEIGHT]={0};
    private Element[][] board=new Element[Sizes.BOARDWIDTH][Sizes.BOARDHEIGHT]; //{{null}}; //initen;

    private roart.pacman.graphic.Board gboard= null;

    private UserInterface u= null;

    public static Board instance() {	//returns the pointer to the instance
	if (instance==null) {
	    instance=new Board();
	}
	return instance;
    }

    public Board() {		//constructor 

	gboard=roart.pacman.graphic.Board.instance();	//get instances of what we need
	//System.out.println("gboard " + gboard);
	u=UserInterface.instance();

	if (u == null) { Pacman.pacexit("no userinterface"); }

	curlist= null; 			//initializers to null

	int i,j;
	for(j=0;j<Sizes.BOARDHEIGHT;j++) {
	    for(i=0;i<Sizes.BOARDWIDTH;i++) { 
		board[i][j]= null;       
	    }
	}
    }

    void start(int level) {	//initialize board for a given level

	int i,j; 			//counters
	Element g;			//pointer to the presently traversed element
	//char t;    			//what code for Element is it
	for(j=0;j<Sizes.BOARDHEIGHT;j++) {	//traverse all
	    for(i=0;i<Sizes.BOARDWIDTH;i++) {        
		switch (boards[level-1][j][0].charAt(i)) {	//cases for the code
		case ' ':g=new roart.pacman.unit.Blank(); break;
		case 'O':g=new roart.pacman.unit.Walls(); break;
		case '.':g=new roart.pacman.unit.Food(); break;
		case 'o':g=new roart.pacman.unit.SuperFood(); break;
		case '_':g=new roart.pacman.unit.SpecialWall(); break;
		default: { g=new roart.pacman.unit.Blank(); Pacman.pacwarning("unrecognized");} break;
		}
		//get pattern translated to graphic element
		//System.out.println("g " + g);
		g.setGraphicElement(gboard.graphele(boards[level-1],i,j));
		board[i][j]=g;
	    } 
	}
    }

    void replace(Element e) {}

    void draw() {		//draw entire board

	int i,j;
	for(j=0;j<Sizes.BOARDHEIGHT;j++) {
	    for(i=0;i<Sizes.BOARDWIDTH;i++) {
		board[i][j].draw(new Point(i,j));
	    }
	}
	oldlist = new java.util.ArrayList<BoardElement>();			//reset spritelists
	curlist = oldlist;
	u.waitsync();			//don't return until everything is drawn
    } 
                         
    void deltaDraw() {		//draw changes of the board
	Point pp;
	//BoardElement temp, oldtemp;	//pointers to liststruct/element, current and to be displayed, and belonging temporaries

	//System.out.print(" lists " + curlist.size() + " " + oldlist.size());
	boardSpriteMovedRedraw();

	drawSprite();
	//	oldlist = new java.util.ArrayList<BoardElement>();
// 	oldtemp=oldlist;
// 	if (zero && oldlist) {	//personal thingie used for debug, not useful
// 	    oldtemp=oldlist;
// 	    while (oldtemp) {
// 		pacwarning("zero");
// 		// printf("%d %d %d   ",oldtemp.gid,oldtemp.x,oldtemp.y);
// 		oldtemp=oldtemp.next;
// 	    } // printf("\n");
// 	    temp=curlist;
// 	    while (temp) {
// 		pacwarning("zero");
// 		//  printf("%d %d %d   ",temp.gid,temp.x,temp.y);
// 		temp=temp.next;
// 	    } // printf("\n\n");
// 	}
 	oldlist = curlist;
 	curlist = new java.util.ArrayList<BoardElement>();
// 	//printf("here4\n");

	u.waitsync();		//don't return until everything is drawn
    }

	private void drawSprite() {
		Point pp;
		for (BoardElement temp : curlist) {			//traverse the list of sprites to be displayed
		    //System.out.println("d " + temp.g.getClass().getName()+ " " + temp.p.toString());
		    pp=temp.getPoint();			//get coordinates of current element
		    // traverse the list of sprites currently display and check coordinates and if equal if the current and new grafical ids are the equal
		    boolean atEnd = true;
		    for (BoardElement oldtemp : oldlist) {
		    	if (oldtemp == null || (pp.equals(oldtemp.getPoint()) && temp.getGid() == oldtemp.getGid())) {
		    		atEnd = false;
		    		break;
		    	}
		    }
			//System.out.println("e " + oldtemp.g.getClass().getName()+ " " + oldtemp.p.toString());
			
		    //if (oldtemp) printf("xxx%d %d %d\n",oldtemp.g,oldtemp.x,oldtemp.y);
		    if (atEnd /*|| i < oldlist.size()*/) {
			//System.out.println("f "+i+ " " + temp.g.getClass().getName());
			temp.getGraphicDynamicElement().draw();//if old temp==0, that 
			//is, if there is no identical
			//new sprite to be displayed where
			//a sprite now is display, then
			//display the new sprite
		    }
		}
	}

	private void boardSpriteMovedRedraw() {
		Point pp;
		for (BoardElement oldtemp : oldlist) {		//traverse the list of last sprites displayed
		    //System.out.println("a " + oldtemp.g.getClass().getName()+" "+oldtemp.p.toString());
		    pp = oldtemp.getPoint();		//get coordinates of current element
		    // traverse the list of sprites to be display and check coordinates
		    boolean atEnd = true;
		    for (BoardElement temp : curlist) {
		    	if (temp == null || pp.equals(temp.getPoint())) {
		    		atEnd = false;
		    		break;
		    	}
		    }
			//System.out.println("b " + temp.g.getClass().getName()+ " "+ temp.p.toString());
		    if (atEnd/* || i < curlist.size()*/) {
			//System.out.println("c "+i+ " " + pp.toString() + " " + board[(int)pp.getX()][(int)pp.getY()].getClass().getName());
			board[(int)pp.getX()][(int)pp.getY()].draw(pp); //if temp==0, that is, if there is no
			//new sprite to be displayed where
			//a sprite now is display, then
			//redraw the element from the board
		    }
		}
	}

public    Element whatis(Point p) {//what "class" element at coordinates is 
	return board[(int)p.getX()][(int)p.getY()];	//return what kind of element is at xx,yy
    }  

    public void eat(Point p) {	//removes whats at coordinates
	board[(int)p.getX()][(int)p.getY()]=new roart.pacman.unit.Blank();//get a new one
	board[(int)p.getX()][(int)p.getY()].setGraphicElement(gboard.graphele(' '));//set it to space=blank

    }

    void sprite(DynamicElement g) {	//let dynamicelement be a sprite
	BoardElement ny=new BoardElement();		//get a new liststruct
	ny.setGraphicDynamicElement(g);				//get pointer to element
	ny.setGid(g.getgid());			//get it's grafical id
	ny.setPoint(g.getxy());		//and coordinates

	curlist.add(ny);
    }

    public void resetoldlist() {
	oldlist= new java.util.ArrayList<BoardElement>();			//reset spritelists
    }

	public static int getFoods() {
		return Sizes.FOODS;
	}

}

 
