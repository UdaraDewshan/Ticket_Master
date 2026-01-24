# 🎫 TicketMaster Core - High-Concurrency Event Booking Engine

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green?style=for-the-badge&logo=spring-boot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-grey?style=for-the-badge)

> A robust backend system designed to handle high-traffic ticket sales, preventing double-bookings through optimistic locking and managing complex dynamic pricing rules using Design Patterns.

---

## 🚀 Project Overview

[cite_start]**TicketMaster Core** is a backend service built for a ticketing platform[cite: 4]. [cite_start]The primary goal of this system is to solve critical industry problems such as **seat double-booking** during high-demand concert sales and system crashes during **dynamic pricing calculations**[cite: 6].

### 🌟 Key Features

* **🔒 The "10-Minute Lock" Strategy (Concurrency Control)**
    * [cite_start]Implements a temporary "HOLD" status on seats for 10 minutes before purchase[cite: 10, 16].
    * [cite_start]Uses **Optimistic Locking** (`@Version`) to handle high contention, ensuring two users cannot book the same seat simultaneously[cite: 22].
    * Automatically manages state transitions: `AVAILABLE` -> `HELD` -> `SOLD`.

* **💸 VIP Tiered Pricing Engine (Strategy Pattern)**
    * [cite_start]Dynamic price calculation based on User Tiers (**Regular, VIP, Platinum**)[cite: 25].
    * [cite_start]**VIP Logic:** 10% discount applied unless the event is "High Demand"[cite: 35].
    * [cite_start]**Platinum Logic:** Priority Access flagging[cite: 36].
    * [cite_start]Implemented using the **Strategy Design Pattern** for extensibility[cite: 37].

* **🛡️ The "Audit Shadow" (Spring AOP)**
    * [cite_start]A security surveillance system that intercepts exceptions using **Spring AOP**[cite: 38].
    * [cite_start]Automatically logs booking failures and potential bot activities to an `audit_logs` table via the `@AuditFailure` custom annotation[cite: 42, 47].

---

## 🏗️ Architecture & Design Patterns

| Component | Pattern / Technology | Purpose |
| :--- | :--- | :--- |
| **Pricing** | Strategy Pattern | To switch between pricing algorithms (VIP, Regular) without `if-else` spaghetti code. |
| **Locking** | Optimistic Locking | To prevent "Lost Update" anomalies when multiple users click "Book" at the same millisecond. |
| **Auditing** | Aspect-Oriented Programming (AOP) | To separate logging logic from business logic (Cross-Cutting Concerns). |
| **Data Access** | Repository Pattern | Spring Data JPA for clean database interactions. |

---

## 🗄️ Database Schema

[cite_start]The system uses a relational database model to track users, events, seats, and audit trails[cite: 48].

```mermaid
erDiagram
    USERS ||--o{ BOOKINGS : makes
    USERS ||--o{ SEATS : holds
    EVENTS ||--|{ SEATS : contains
    SEATS ||--o{ BOOKINGS : reserved_in
    USERS ||--o{ AUDIT_LOGS : triggers

    SEATS {
        long id
        string status "AVAILABLE, HELD, SOLD"
        datetime hold_expiry
        int version "Optimistic Lock"
    }
    USERS {
        long id
        enum tier "REGULAR, VIP, PLATINUM"
    }
