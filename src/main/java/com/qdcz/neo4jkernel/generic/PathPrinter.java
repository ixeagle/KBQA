package com.qdcz.neo4jkernel.generic;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.traversal.Paths;


public class PathPrinter implements Paths.PathDescriptor<Path>{

    private final String nodePropertyKey;

    public PathPrinter(String nodePropertyKey){
        this.nodePropertyKey = nodePropertyKey;
    }

    @Override
    public String nodeRepresentation(Path path, Node node){
        return "("+node.getAllProperties().toString()+")";
//        return "(" + node.getProperty( nodePropertyKey, "" ) + ")";
    }

    @Override
    public String relationshipRepresentation(Path path, Node from, Relationship relationship){
        String prefix = "--", suffix = "--";
        if (from.equals( relationship.getEndNode())){
            prefix = "<--";
        } else {
            suffix = "-->";
        }
        //relationship.getType().toString()
        return prefix + "[" +relationship.getAllProperties()+ "]" + suffix;
    }
}