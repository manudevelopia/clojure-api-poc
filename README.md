

my-api/
├── deps.edn
├── .env
├── resources/
│   └── logback.xml
├── src/
│   └── my_api/
│       ├── core.clj                  ;; entry point (HTTP adapter)
│       ├── config.clj                ;; load config from .env
│       ├── env.clj                   ;; .env parser
│       ├── middleware.clj            ;; logging, error handling
│       ├── domain/                   ;; domain logic, data, protocols
│       │   ├── user.clj              ;; User entity + business rules
│       ├── ports/                    ;; abstract interfaces (protocols)
│       │   └── user_repository.clj   ;; e.g., `UserRepository` protocol
│       ├── app/                      ;; use cases / services
│       │   └── user_service.clj      ;; implements user logic via ports
│       └── adapters/
│           ├── db/
│           │   ├── core.clj          ;; DB connection
│           │   └── user_postgres.clj ;; implements user repo with next.jdbc
│           └── http/
│               ├── routes.clj       ;; Javalin setup, routing
│               └── user_handler.clj ;; Javalin-compatible handlers
└── test/
└── my_api/
└── user_test.clj
