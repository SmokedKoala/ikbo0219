package ru.mirea.practice3;

public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

            public MovableRectangle(int x1, int y1, int x2, int y2, int x1Speed, int y1Speed, int x2Speed, int y2Speed) {
                this.topLeft = new MovablePoint(x1, y1, x1Speed, y1Speed);
                this.bottomRight = new MovablePoint(x2, y2, x2Speed, y2Speed);
            }

            @Override
            public void moveUp() {
                if (this.speedCheck()==true){
                    this.topLeft.moveUp();
                    this.bottomRight.moveUp();
                }
            }

            @Override
            public void moveDown() {
                if (this.speedCheck()==true){
                    this.topLeft.moveDown();
                    this.bottomRight.moveDown();
            }
            }

            @Override
            public void moveLeft() {
                if (this.speedCheck()==true){
                this.topLeft.moveLeft();
                this.bottomRight.moveLeft();
                }
            }

            @Override
            public void moveRight() {
                if (this.speedCheck()==true){
                this.topLeft.moveRight();
                this.bottomRight.moveRight();
                }
            }

            @Override
            public String toString() {
                return "Rectangle with " + "topLeft point at = " + topLeft + " bottomRight point at = " + bottomRight;
            }
            public boolean speedCheck(){
                if (topLeft.xSpeed==bottomRight.xSpeed)
                    if (topLeft.ySpeed==bottomRight.ySpeed)
                        return true;
                    else return false;
                else return false;
            }
        }

