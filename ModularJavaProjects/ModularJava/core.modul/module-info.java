module core.modul {
	exports core.modul;
	//requires java.base; implicitly so no need to define 
	/**
	 * Circular Dependencies Not Allowed
    It is not allowed to have circular dependencies between modules. In other words, If module A requires module B, then module B cannot also require module A. The module dependency graph must be an acyclic graph.

 you can not do this: 
 
		requires app.client.modul;
	 */
}