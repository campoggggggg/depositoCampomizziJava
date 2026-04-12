# Progetto Java — Shop con Design Pattern

Applicazione Java con menu a console che simula un sistema di e-commerce. Supporta tre tipi di utente (Normal, Pro, Admin), gestione prodotti, acquisti con sconto, varianti cromatiche e di taglia, e spedizioni. Tutti i dati sono persistiti su database MySQL.

---

## Flusso di lavoro spiegato

1. Contesto
2. Progettazione DB 
3. Selezione Design Pattern
4. Divisione e scrittura
5. Piccole correzioni

Inizialmente ho cercato di definire un contesto chiaro in cui lavorare: ho pensato ad una piccola simulazione di un e-commerce di abbigliamento. Successivamente, ho progetto la struttura del database. E' stata la mia prima scelta per garantire coerenza, scalabilità ed evitare refactoring inutili che mi avrebbe portato via tempo.
- La tabella sales gestisce le transazioni e contiene riferimenti a user, product e shipment tramite ID, oltre a quantità, prezzo totale e data di vendita; contiene FOREIGN KEY con le tabelle users, products e shipments.
- La tabella users include gli attributi id, username, password e un campo ENUM per la gestione dei ruoli (NORMAL, PRO, ADMIN).
- La tabella products contiene id, nome, descrizione, prezzo e un campo dedicato alla quantità disponibile; è inoltre collegata tramite FOREIGN KEY alla tabella categories per la classificazione dei prodotti.
- La tabella shipments definisce le modalità di spedizione disponibili con i rispettivi costi.

In seguito mi sono concentrato a dividere il progetto in sottoproblemi da risolvere, sfruttando i Design Pattern per migliorare la modularità e manutenibilità del codice:

| Pattern | Classe/i | Scopo |
|---|---|---|
| Singleton | `DatabaseManager` | Unica istanza della connessione al database MySQL |
| Factory Method | `UserFactory` | Crea NormalUser / ProUser / Admin dal tipo stringa |
| Strategy | `DiscountStrategy`, `NoDiscount`, `ProDiscount` | Logica di spedizione intercambiabile a runtime per tipo di utente |
| Decorator | `ProductDecorator`, `ColorDecorator`, `SizeDecorator` | Estende dinamicamente colore e taglia a un prodotto a runtime |
| Facade | `SalesManager` | Interfaccia unificata e semplificata delle funzionalità del sistema |


Mirko: "Cosa avresti fatto con più tempo?"
Gabriele: "Avrei dedicato più tempo a costruire un DB più ampio. Credo sia il punto di forza del progetto ed averne uno più strutturato mi avrebbe permesso più implementazioni semplici. Ad esempio, testando verso la fine mi sono accorto di come ci siano errori logici nella sua gestione, come la quantità legata al semplice prodotto invece che a prodotto + taglia (Ho 30 magliette ma diventano S, M, L etc. a runtime, e non ho un db forte che mi permette di gestirle in maniera diversa). Altri piccoli dettagli che avrei voluto aggiungere sono: una gestione diversa delle scarpe, con marca e numero invece che colore e taglia, e piccoli dettagli aggiuntivi per utente PRO. Non ho implementato un'observer poiché sul momento non avevo idee su cosa avrebbe potuto gestire in maniera efficiente (e non solo buttato lì)."

---

## Struttura dei package

```
src/
├── App.java                  (entry point)
├── db/
│   └── DatabaseManager.java  (Singleton)
├── decorator/
│   ├── ProductDecorator.java
│   ├── ColorDecorator.java
│   ├── SizeDecorator.java
├── factory/
│   └── UserFactory.java
├── facade/
│   └── SalesManager.java
├── model/
│   ├── User.java             (abstract)
│   ├── NormalUser.java
│   ├── ProUser.java
│   ├── Admin.java
│   └── Product.java
└── strategy/
    ├── DiscountStrategy.java (interface)
    ├── NoDiscount.java
    └── ProDiscount.java
```

---

## Tipi di utente e comportamento

| Tipo | Sconto | Storico acquisti | Gestione admin |
|---|---|---|---|
| NORMAL | Nessuno | No | No |
| PRO | 5% | Sì | No |
| ADMIN | Nessuno | No | Sì (prezzi, qty, desc, utenti, vendite) |

---

## Logica di acquisto

1. L'utente seleziona un prodotto tramite ID.
2. Sceglie colore (`BIANCO` / `NERO` / `ROSSO`) e taglia (`S` / `M` / `L` / `XL`).
3. Il prezzo viene scontato in base al tipo utente (Strategy pattern).
4. Se il totale scontato supera €100, viene assegnata automaticamente la spedizione EXPRESS gratuita.
5. Altrimenti l'utente sceglie il tipo di spedizione tra quelle disponibili.
6. L'acquisto viene registrato nella tabella `sales` e la quantità del prodotto decrementata.
