package Libs;
/*
* Árvore AVL podem ser empregadas na implementação de conjuntos, principalmente aqueles cujas chave não são números inteiros.
  A complexidade das principais operações de conjuntos usando árvore AVL:
    * Inserir - O(log n);
    * Remover - O(log n);
    * Pertence - O(log n);
    * União - O(n.log n);
    * Interseção - O(n.log n).
*
* */

import modelo.No;

import java.util.ArrayList;

public class Avl {

    protected No raiz;

    public void insert(int k) {
        No n = new No(k);
        insertAVL(this.raiz, n);
    }


    private void insertAVL(No aComparar, No aInserir) {
        if (aComparar == null) {
            this.raiz = aInserir;
        } else {
            if (aInserir.getChave() < aComparar.getChave()) {
                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                } else {
                    insertAVL(aComparar.getEsquerda(), aInserir);
                }
            } else if (aInserir.getChave() > aComparar.getChave()) {
                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                } else {
                    insertAVL(aComparar.getDireita(), aInserir);
                }
            } else {
                // O nó já existe
            }
        }
    }


    private void verificarBalanceamento(No atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();
        if (balanceamento == -2) {
            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);
            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }
        } else if (balanceamento == 2) {
            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);

            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }
        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }


    public boolean member(int k) {
      return memberAVL(this.raiz, k);
    }

    private boolean memberAVL(No atual, int k) {
        if (atual == null) {
            return false;
        } else {
            if (atual.getChave() > k) {
                memberAVL(atual.getEsquerda(), k);
            } else if (atual.getChave() < k) {
                memberAVL(atual.getDireita(), k);
            } else if (atual.getChave() == k) {
                return true;
            }
        }

        return false;
    }


    public void delete(int k) {
        deleteAVL(this.raiz, k);
    }


    private void deleteAVL(No atual, int k) {
        if (atual == null) {
            return;
        }else{
            if (atual.getChave() > k) {
                deleteAVL(atual.getEsquerda(), k);
            } else if (atual.getChave() < k) {
                deleteAVL(atual.getDireita(), k);
            } else if (atual.getChave() == k) {
                removerNoEncontrado(atual);
            }
        }
    }

    private void removerNoEncontrado(No aRemover) {
        No r;
        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {
            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            r = aRemover;
        } else {
            r = sucessor(aRemover);
            aRemover.setChave(r.getChave());
        }

        No p;
        if (r.getEsquerda() != null) {
            p = r.getEsquerda();
        } else {
            p = r.getDireita();
        }

        if (p != null) {
            p.setPai(r.getPai());
        }

        if (r.getPai() == null) {
            this.raiz = p;
        } else {
            if (r == r.getPai().getEsquerda()) {
                r.getPai().setEsquerda(p);
            } else {
                r.getPai().setDireita(p);
            }
            verificarBalanceamento(r.getPai());
        }
        r = null;
    }

    public No rotacaoEsquerda(No inicial) {

        No direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    public No rotacaoDireita(No inicial) {

        No esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }
        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public No duplaRotacaoEsquerdaDireita(No inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    public No duplaRotacaoDireitaEsquerda(No inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public No sucessor(No q) {
        if (q.getDireita() != null) {
            No r = q.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            No p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(No atual) {
        if (atual == null) {
            return -1;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private void setBalanceamento(No no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    final protected ArrayList<No> inorder() {
        ArrayList<No> ret = new ArrayList<No>();
        inorder(raiz, ret);
        return ret;
    }

    final protected void inorder(No no, ArrayList<No> lista) {
        if (no == null) {
            return;
        }
        inorder(no.getEsquerda(), lista);
        lista.add(no);
        inorder(no.getDireita(), lista);
    }
}

