# Assignment 5: Strategy Pattern

## 1. Class Responsibility Table (SRP Check)
*Each class and its responsibility in one sentence, max 25 words, without "if", "and", "or", "but".*

| Class Name | Responsibility |
| :--- | :--- |
| `PricingStrategy` | Defines calculate method for price calculations. |
| `StandardPricing` | Returns unmodified base order price. |
| `HappyHoursPricing` | Applies discount factor to order amount. |
| `BanquetPricing` | Adds fixed service fee to total. |
| `OrderPricingContext` | Delegates price calculation current strategy object. |
| `PricingSelector` | Selects pricing strategy based condition parameters. |
| `ChefAssignmentStrategy` | Defines assignment method for kitchen staff. |
| `FastestChefStrategy` | Assigns order fastest available cook. |
| `SeniorChefStrategy` | Assigns order senior chef for complexity. |
| `LoadBalancedChefStrategy` | Assigns order evaluating external queue data. |
| `KitchenLoadService` | Provides current kitchen workload telemetry metrics. |

---

## 2. Why Strategy and not State or Template Method?
Our solution implements the **Strategy pattern** because the classes represent entirely interchangeable algorithms that clients choose and swap dynamically at runtime without sharing internal state machine transitions (unlike the **State pattern**, where objects alter their behavior based on internal state changes). Furthermore, unlike **Template Method**, which relies on class inheritance and abstract base classes with fixed skeleton steps, Strategy encapsulates algorithms behind clean interfaces using pure composition, allowing complete runtime substitution without subclassing restrictions.

---

## 3. Refactoring Commits
* **Before Refactoring (Bad code with if-else):** [Commit a75935a](https://github.com/R1chi326/Restaurant-Kitchen-Assignment-5/commit/a75935a)
* **After Refactoring (Strategy Pattern implemented):** [Commit e604d05](https://github.com/R1chi326/Restaurant-Kitchen-Assignment-5/commit/e604d05)