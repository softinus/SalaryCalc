#pragma strict
var SprNormal : Sprite;
var SprHover : Sprite;
 
function OnMouseEnter () {
 Sprite. = SprHover;
 
}
 
function OnMouseExit(){
 Sprite = SprNormal;
}
 
function OnMouseDown(){
 Debug.Log("clicked");
}