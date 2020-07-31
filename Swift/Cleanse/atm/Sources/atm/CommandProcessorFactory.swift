//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation
import Cleanse

struct CommandProcessorFactory: Cleanse.RootComponent {
    
    typealias Root = CommandProcessor
    typealias Scope = Singleton
    
    static func configureRoot(binder bind: ReceiptBinder<Root>) -> BindingReceipt<Root> {
        return bind.to(factory: CommandProcessor.init)
    }
    
    static func configure(binder: Binder<Scope>) {
        binder.include(module: CommandRouterModule.self)
        binder.include(module: LoginCommandModule.self)
        binder.include(module: HelloWorldCommandModule.self)
        binder.include(module: PrintModule.self)
        binder.include(module: DatabaseModule.self)
        binder.include(module: AmountsModule.self)
        
        binder.install(dependency: UserCommandsRouter.self)
    }
    
    static func processor() -> CommandProcessorFactory.Root {
        try! ComponentFactory.of(CommandProcessorFactory.self).build(())
    }
    
}
