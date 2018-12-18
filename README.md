# api-swgoh-gg - Work In Progress
Java client wrapper for the API at https://swgoh.gg/api

# Usage

    Client swgoh = Client.get();
    swgoh.characters().list().forEach(System.out::println);