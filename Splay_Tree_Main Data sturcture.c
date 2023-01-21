
#include<stdio.h>
#include<stdlib.h>
#include <stdbool.h>
#include<time.h>
time_t t;
struct node
{
    struct node *left;
    struct node *right;
    struct node *parent;
    int vertex;
};

struct node *root;

void Right_Rotation(struct node *P)
{
    struct node *child=P->left;
    struct node *X=child->right;
    struct node *Grand_Parent=P->parent;
    if(Grand_Parent!=0)
    {
        if(Grand_Parent->right==P)
        {
            Grand_Parent->right=child;
        }
        else
        {
            Grand_Parent->left=child;

        }

    }
    if(X!=0)
    {
        X->parent=P;

    }

    child->parent=Grand_Parent;
    child->right=P;

    P->parent=child;
    P->left=X;
}
void Left_Rotation(struct node *P)
{
    struct node *child=P->right;
    struct node *X=child->left;
    struct node *Grand_Parent=P->parent;
    if(Grand_Parent!=0)
    {
        if(Grand_Parent->right==P)
        {
            Grand_Parent->right=child;
        }
        else
            Grand_Parent->left=child;
    }
    if(X!=0)
    {
        X->parent=P;
    }

    child->parent=Grand_Parent;
    child->left=P;

    P->parent=child;
    P->right=X;
}

void Splay(struct node *child)
{
    while(1)
    {
        struct node *parent=child->parent;
        if(parent==0)
        {
            break;
        }
        struct node *Grand_Parent=parent->parent;

        if(Grand_Parent==0)//Zig
        {
            if(parent->left==child)
            {
                Right_Rotation(parent);
            }

            else//zag
            {
                Left_Rotation(parent);
            }

            break;
        }
        if(Grand_Parent->left==parent)
        {
            if(parent->left==child)
            {
                //ZigZig
                Right_Rotation(Grand_Parent);
                Right_Rotation(parent);
            }
            else
            {
                //ZigZag
                Left_Rotation(parent);
                Right_Rotation(Grand_Parent);
            }
        }
        else
        {
            if(parent->left==child)
            {
                //ZigZag
                Right_Rotation(parent);
                Left_Rotation(Grand_Parent);
            }
            else
            {
                //ZigZig
                Left_Rotation(Grand_Parent);
                Left_Rotation(parent);
            }
        }
    }
    root=child;
}

void Insert(int vertex)
{
    if(root==0)
    {
        root=(struct node *)malloc(sizeof(struct node));
        root->left=NULL;
        root->right=NULL;
        root->parent=NULL;
        root->vertex=vertex;
        return;
    }

    struct node *P=root;

    while(1)
    {
        if(P->vertex==vertex)
            break;

        if(vertex < (P->vertex) )
        {
            if(P->left!=0)
            {
                P=P->left;
            }

            else
            {
                P->left=(struct node *)malloc(sizeof(struct node));
                P->left->parent=P;
                P->left->right=NULL;
                P->left->left=NULL;
                P->left->vertex=vertex;
                P=P->left;
                break;
            }
        }
        else
        {
            if(P->right!=0)
            {
                P=P->right;
            }
            else
            {
                P->right=(struct node *)malloc(sizeof(struct node));
                P->right->parent=P;
                P->right->right=NULL;
                P->right->left=NULL;
                P->right->vertex=vertex;
                P=P->right;
                break;
            }
        }
    }
    Splay(P);
}

void InOrder(struct node *RH)
{
    if(RH==0)
        return;

    InOrder(RH->left);
    printf("vertex: %d ",RH->vertex);

    if(RH->left)
        printf("left: %d ",RH->left->vertex);
    if(RH->right)
        printf("right: %d ",RH->right->vertex);
    puts("");
    InOrder(RH->right);
}

struct node* Search(int vertex)
{
    if(root==0)
    {
        return NULL;
    }
    struct node *P=root;

    while(P)
    {
        if(P->vertex==vertex)
        {
            break;
        }

        if(vertex<(P->vertex))
        {
            if(P->left!=0)
            {
                P=P->left;
            }

            else
            {
                break;
            }

        }
        else
        {
            if(P->right!=0)
            {
                P=P->right;
            }

            else
            {
                break;
            }

        }
    }

    Splay(P);
    if(P->vertex==vertex)
    {
        return P;
    }

    else
    {
        return NULL;
    }

}

bool Delete(int vertex)
{
    struct node *ND=Search(vertex);

    if(ND==0)
    {
        return 0;
    }

    Splay(ND);

    struct node *P=ND->left;

    if(P==0)
    {
        root=ND->right;
        root->parent=NULL;
        free(ND);
        return 1;
    }

    while(P->right)
        P=P->right;
    if(ND->right!=0)
    {
        P->right=ND->right;
    }
    root=ND->left;
    root->parent=NULL;
    free(ND);
    return 1;
}
int main()
{
    bool fls= false;
    int choice;
    int data;

    while(true)
    {
        system("Color 9f");
        time(&t);
        printf("\n\n\t%65s\n\n",ctime(&t));
        printf("\t\t\t\t\t\t-------------------------------\n");
        printf("\t\t\t\t\t\t<<Welcome TO Splay Tree Menu>>\n");
        printf("\t\t\t\t\t\t-------------------------------\n\n\n");
        printf("\t\t\t             ***********************************************");
        printf("\n\t\t\t             ***********************************************\n");
        printf("\t\t\t             **\t\t\t\t\t\t  **\n");
        printf("\t\t\t             **   \t\t\t\t\t  **\n");
        printf("\t\t\t             **     push 1.Insert     \t\t\t  **\n");
        printf("\t\t\t             **     push 2.Delete    \t\t\t  **\n");
        printf("\t\t\t             **     push 3.Search      \t\t\t  **\n");
        printf("\t\t\t             **     push 4.Print    \t\t\t  **\n");
        printf("\t\t\t             **     push 5.Exit    \t\t\t  **\n");
        printf("\t\t\t             **   \t\t\t\t\t  **\n");
        printf("\t\t\t             **   \t\t\t\t\t  **");
        printf("\n\t\t\t             ***********************************************");
        printf("\n\t\t\t             ***********************************************\n");
        printf("\t\t\t\t\t\tEnter Your Choice:");

        scanf("%d",&choice);
        if(choice==1)
        {
            printf("\n\nEnter the Node For Insert:");
            scanf("%d",&data);
            Insert(data);
        }
        else if(choice==2)
        {
            printf("Enter the Node For Delete:");
            scanf("%d",&data);
            if(Delete(data))
                printf("Yes!!Successfully Deleted Is %d!\n",data);
            else
                printf("Couldn't Find is the Node %d!\n",data);

        }
        else if(choice==3)
        {
            printf("Enter the Node For Search:");
            scanf("%d",&data);
            if(!Search(data))
                printf("Couldn't Find is the Node %d!\n",data);
            else
                printf("Yes!!Successfully Found is the Node %d!\n",data);
        }
        else if(choice==4)
        {
            if(root)
                printf("root: %d\n",root->vertex);
            InOrder(root);
        }


        if(choice==5)
        {

            fls=false;
            break;
        }

    }
    getch();
        return 0;


}
