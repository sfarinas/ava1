#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct List {
    struct Node* head;
    struct Node* tail;
};

void create(struct List* list) {
    list->head = NULL;
    list->tail = NULL;
}

void display(struct List* list) {
    struct Node* current = list->head;
    printf("Lista: ");
    while (current != NULL) {
        printf("%d ->> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

void insert(struct List* list, int value) {
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = value;
    new_node->next = NULL;

    struct Node* current = list->head;
    struct Node* previous = NULL;

    while (current != NULL && current->data < value) {
        previous = current;
        current = current->next;
    }

    new_node->next = current;

    if (previous != NULL) {
        previous->next = new_node;
    } else {
        list->head = new_node;
    }
}

void remove_element(struct List* list, int value) {
    struct Node* current = list->head;
    struct Node* previous = NULL;

    while (current != NULL && current->data != value) {
        previous = current;
        current = current->next;
    }

    if (previous != NULL) {
        if (current != NULL) {
            previous->next = current->next;
            free(current);
            printf("Valor Removido\n");
        } else {
            printf("Valor não encontrado\n");
        }
    } else {
        printf("Lista Vazia\n");
    }
}

void modify(struct List* list, int oldValue, int newValue) {
    struct Node* current = list->head;
    struct Node* previous = NULL;

    while (current != NULL && current->data != oldValue) {
        previous = current;
        current = current->next;
    }

    if (previous != NULL) {
        if (current != NULL) {
            current->data = newValue;
            printf("Alterado Com Sucesso! ;-D\n");
        } else {
            printf("Valor Indisponível... :-(\n");
        }
    } else {
        printf("Lista Vazia\n");
    }
}

int is_empty(struct List* list) {
    return list->head == NULL;
}

void reset(struct List* list) {
    struct Node* temp = list->head;
    if (temp != NULL) {
        while (temp != NULL) {
            list->head = temp->next;
            free(temp);
            temp = list->head;
        }
        printf("Todos os elementos foram removidos!\n");
    } else {
        printf("Lista Vazia\n");
    }
}

int main() {
    struct List created_list;
    int value1, option, value2;
    create(&created_list);

    printf("ESTRUTURA DE DADOS\n");
    while (1) {
        printf("\n 1 - Inserir Elemento\n");
        printf(" 2 - Mostrar Lista\n");
        printf(" 3 - Alterar Elemento da Lista\n");
        printf(" 4 - Remover Elemento da Lista\n");
        printf(" 5 - Sair\n");
        printf("\n Digite o Número da Opção: ");

        while (scanf("%d", &option) != 1) {
            printf("\n ===== ENTRADA INVÁLIDA. ===== \n");
            printf("Digite um número inteiro: ");
            scanf("%*s"); // Descarta a entrada inválida
        }

        getchar(); // Limpa o caractere de nova linha do buffer

        switch (option) {
            case 1:
                printf("Digite um Valor numérico: ");
                scanf("%d", &value1);
                insert(&created_list, value1);
                break;
            case 2:
                if (is_empty(&created_list)) {
                    printf("Lista Vazia...\n");
                } else {
                    display(&created_list);
                }
                break;
            case 3:
                printf("Valor Para Ser Alterado: ");
                scanf("%d", &value1);
                printf("Novo Valor: ");
                scanf("%d", &value2);
                modify(&created_list, value1, value2);
                break;
            case 4:
                printf("Valor: ");
                scanf("%d", &value1);
                remove_element(&created_list, value1);
                break;
            case 5:
                reset(&created_list);
                exit(0);
            default:
                printf("Opção Inválida!\n");
        }
    }
    return 0;
}
