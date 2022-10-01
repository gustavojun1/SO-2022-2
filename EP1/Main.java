package EP1;


import java.util.concurrent.*;

class Tarefa implements Runnable {
    // atributo numérico
		int num;

		// construtor
    Tarefa(int num) {
        this.num = num;
    }    

		// método obrigatório run, que chama helloWorld()
    public void run() {
        try {
            helloWorld();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

		// método de mensagem
    private void helloWorld() {
        System.out.println("Hello world from thread n° " + num);
    }
}	

class Main {
    public static void main(String[] args) {
        // inicialização das tarefas
        Tarefa tarefa1 = new Tarefa(1);
        Tarefa tarefa2 = new Tarefa(2);
        Tarefa tarefa3 = new Tarefa(3);
        
        // criação e execução das tarefas em threads
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(tarefa1);    
        ex.execute(tarefa2);
        ex.execute(tarefa3);

        // terminação das threads
        ex.shutdown();
    }
}
