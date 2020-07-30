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
    typealias Scope = Singleton
    
    static func configureRoot(binder bind: ReceiptBinder<Root>) -> BindingReceipt<Root> {
        return bind.to(factory: CommandRouter.init)
    }
    
    static func configure(binder: Binder<Scope>) {
        binder.include(module: LoginCommandModule.self)
        binder.include(module: HelloWorldCommandModule.self)
        binder.include(module: PrintModule.self)
        binder.include(module: DatabaseModule.self)
        binder.include(module: DepositCommandModule.self)
    }
    
    static func create() -> CommandRouterFactory.Root {
        try! ComponentFactory.of(CommandRouterFactory.self).build(())
    }
    
}
