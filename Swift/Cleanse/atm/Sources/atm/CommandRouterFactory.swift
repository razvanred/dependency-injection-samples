//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation
import Cleanse

struct CommandRouterFactory: Cleanse.RootComponent {
    
    typealias Root = CommandRouter
    typealias Scope = Unscoped
    
    static func configureRoot(binder bind: ReceiptBinder<Root>) -> BindingReceipt<Root> {
        return bind.to(factory: CommandRouter.init)
    }
    
    static func configure(binder: Binder<Scope>) {
        binder.include(module: HelloWorldCommandModule.self)
        binder.include(module: PrintModule.self)
    }
    
    static func create() -> CommandRouterFactory.Root {
        try! ComponentFactory.of(CommandRouterFactory.self).build(())
    }
    
}
