# Progetto Java — Shop con Design Pattern

Applicazione Java con menu a console che simula un sistema di e-commerce. Supporta tre tipi di utente (Normal, Pro, Admin), gestione prodotti, acquisti con sconto, varianti cromatiche e di taglia, e spedizioni. Tutti i dati sono persistiti su database MySQL.

---

## Design Pattern implementati

| Pattern | Classe/i | Scopo |
|---|---|---|
| Singleton | `DatabaseManager` | Unica istanza della connessione MySQL |
| Factory Method | `UserFactory` | Crea NormalUser / ProUser / Admin dal tipo stringa |
| Strategy | `DiscountStrategy`, `NoDiscount`, `ProDiscount` | Calcolo sconto intercambiabile per tipo utente |
| Decorator | `ProductDecorator`, `ColorDecorator`, `SizeDecorator` | Aggiunge colore e taglia a un prodotto a runtime |
| Facade | `SalesManager` | Nasconde tutta la logica SQL al layer App |

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
│   └── ProductVariants.java  (costanti colori/taglie)
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

## Setup del database MySQL

Eseguire il file `setup.sql` allegato:

```bash
mysql -u root -p < setup.sql
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
