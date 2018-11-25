package model;

import java.awt.Image;

import showboard.ISquare;

public interface IElement extends ISquare {
  Permeability getPermeability ();
  Image getImage ();
  ISprite getSprite();
}
