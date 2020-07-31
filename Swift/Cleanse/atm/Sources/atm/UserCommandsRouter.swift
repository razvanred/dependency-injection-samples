//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation
import Cleanse

struct UserCommandsRouter: Component {
    
    typealias Seed = Account
    
    typealias Scope = Unscoped
    
    typealias Root = CommandRouter
    
    static func configure(binder: Binder<Scope>) {
        binder.include(module: UserCommandsModule.self)
    }
    
    static func configureRoot(binder bind: ReceiptBinder<Root>) -> BindingReceipt<Root> {
        bind.to(factory: CommandRouter.init)
    }
    
}
