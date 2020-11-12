# WADE-hackathon

The model contains Subjects: University, Faculty and the relationships between them (e.g faculty belongs to university).
There is also the relationship between faculty and city, and the type of faculty (private, state).

The generated RDF model is located at src\main\java\hack2\rdf.xml

Tried to use online RDF to graph but didn't work for big RDF file.
graphviz.svg is a svg of a small mocked RDF genetated by:
1. Converting RDF to graphviz definition at https://www.easyrdf.org/converter
2. Previewing graphviz at https://dreampuf.github.io/GraphvizOnline

Tried to use Gephi in order to get a PNG of the graph, but didn't have enough time.

We used Jena in order to create RDF model from java objects constructed from the .xls file.
We tried to use Jena for building SPARQL queries.

Contributions:
1. Tatu Georgian:
    Parse XML
    Create java models
2. Lionte Bogdan:
    Create RDF from java models with Jena.
    Create java models
    Tried to build SPARQL query
    Tried to create graph form RDF
