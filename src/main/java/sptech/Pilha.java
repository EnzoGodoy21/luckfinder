package sptech;

public class Pilha<T> {
    private T[] stack;
    private int top;

    public Pilha(int size) {
        this.stack = (T[]) new Object[size];
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top < 0;
    }

    public boolean isFull(){
        return this.top == stack.length-1;
    }

    public void push(T elem){
        if(!this.isFull()){
            this.stack[++this.top] = elem;
        }else{
            System.out.println("Lista Cheia");
        }
    }

    public T pop(){
        if(!this.isEmpty()){
            return this.stack[this.top--];
        }else{
            System.out.println("Lista Vazia");
            return null;
        }
    }

    public T peek(){
        if(!this.isEmpty()){
            return this.stack[this.top-1];
        }else {
            return null;
        }
    }

    public void showAll(){
        if(this.isEmpty()){
            System.out.println("Pilha vazia");
        }else{
            for (int i = this.top; i >= 0; i--) {
                System.out.println(this.stack[i]);
            }
        }
    }

    public int size(){
        return this.top + 1;
    }
}
