# biblioteca que permite interagir com o sistema operacional
import os

# método que cria um processo filho e retorna:
#   no processo pai, o id do processo pai (>0)
#   no processo filho, 0
id_processo = os.fork()

# o id do processo pai (>0)
if(id_processo > 0):
    print("Hello World do processo pai!")
    print("Meu ID: ", os.getpid())
    print("ID do meu filho: ", id_processo)
# 0 representa um processo filho
else:
    print("Hello World processo filho!")
    print("Meu ID: ", os.getpid())
    print("ID do meu pai: ", os.getppid())    