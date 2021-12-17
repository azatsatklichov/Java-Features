#include <stdio.h>
#include <graalvm/llvm/polyglot.h>

int main() {
    void *array = polyglot_eval("js", "[1,2,42,4]");
    int element = polyglot_as_i32(polyglot_get_array_element(array, 2));
    printf("%d\n", element);
    return element;
}