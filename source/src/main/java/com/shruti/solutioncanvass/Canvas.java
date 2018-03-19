package com.shruti.solutioncanvass;

public interface Canvas {

    void addEntity(Entity entity) throws InvalidEntityException;

    String render();
}
