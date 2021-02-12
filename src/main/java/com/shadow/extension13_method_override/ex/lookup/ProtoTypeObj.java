package com.shadow.extension13_method_override.ex.lookup;

import com.shadow.utils.ConsolePrinter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author shadow
 * @create 2021-02-11
 * @description
 */
@Component
@Scope("prototype")
public class ProtoTypeObj {

    public void m() {
        ConsolePrinter.printlnCyan(this.hashCode());
    }

}
