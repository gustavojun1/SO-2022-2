#include <stdio.h>
#include <unistd.h>  // dependência da biblioteca seguinte  
#include <pthread.h> // biblioteca de POSIX threads  

void* tarefa(void* num) {
    for(int i = 0; i < 3; i++) {
        sleep(1); // printando a cada 1 seg
        printf("Tarefa n°%d sendo executada...\n", * (int *)num);
    }

    return NULL;
}

int main() {
    // instanciação das threads
    pthread_t thread1;
    pthread_t thread2;
    pthread_t thread3;

    // inicializando as threads (com os respectivos identificadores)
    pthread_t* thread_array[] = {&thread1, &thread2, &thread3};
    int numbers[] = {1, 2, 3};
    for(int i = 0; i < 3; i++) {
        pthread_create(thread_array[i], NULL, tarefa, &(numbers[i]));
    }

    // importante colocar porque garante que a função terminará de ser executada antes de sair da thread
    pthread_exit(NULL);
}
