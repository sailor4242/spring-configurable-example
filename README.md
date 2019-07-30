# Example of @EnableSpringConfigured and @Configurable usage with compile time weaving.

Beware of IDE misconfiguration for aspects, use maven to build.

``mvn clean install``


## Cadence Example

To run cadence example you need to switch profile from __default__ to __cadence__ in __application.yml__

Run cadence server with ``docker-compose up`` before running the app.

Also you might need to specify **'USER'** env property with any value.
