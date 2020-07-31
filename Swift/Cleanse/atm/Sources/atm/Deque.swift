//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation

protocol Deque {
    
    associatedtype Element
    
    /// Pushes an element onto the stack represented by this deque (in other words,
    /// at the head of this deque).
    ///
    /// This method is equivalent to [addFirst](x-source-tag://addFirst).
    ///
    /// - Parameter e: the element to push
    func push(_ e: Element)
    
    /// Inserts the specified element at the front of this deque.
    ///
    /// - Parameter e: the element to add
    ///
    /// - Tag: addFirst
    func addFirst(_ e: Element)
    
    /// Retrieves, but does not remove, the head of the queue represented by this deque
    /// (in other words, the first element of the deque), or returns `nil` if this deque is empty.
    ///
    /// This method is equivalent to [peekFirst](x-source-tag://peekFirst).
    ///
    /// - returns: The head of the queue represented by this queue, or `nil`
    /// if this deque is empty
    func peek() -> Element?
    
    /// Retrieves, but does not remove, the first element of this deque, or returns `nil`
    /// if the deque is empty.
    ///
    /// - returns: The head of this deque, or `nil` if this deque is empty
    ///
    /// - Tag: peekFirst
    func peekFirst() -> Element?
    
    /// Pops an element from the stack represented by this queue. In other
    /// words, removes and returns the first element of this deque.
    ///
    /// This method is equivalent to [removeFirst](x-source-tag://removeFirst).
    func pop() -> Element
    
    /// Retrieves and removes the first element of this deque.
    ///
    /// The deque should be not empty.
    ///
    /// - returns: the head of this deque
    ///
    /// - Tag: removeFirst
    func removeFirst() -> Element
    
    /// Size of the deque
    var count: Int { get }
    
    /// Returns `true` if the deque is empty, `false` otherwise.
    var isEmpty: Bool { get }
    
}

class ArrayDeque<Element> : Deque {
    
    typealias Element = Element
    
    private var elements: [Element]
    
    init() {
        elements = [Element]()
    }
    
    func push(_ e: Element) {
        addFirst(e)
    }
    
    func addFirst(_ e: Element) {
        elements.append(e)
    }
    
    func peek() -> Element? {
        peekFirst()
    }
    
    func peekFirst() -> Element? {
        elements.last
    }
    
    func pop() -> Element {
        removeFirst()
    }
    
    func removeFirst() -> Element {
        elements.removeLast()
    }
    
    var count: Int { elements.count }
    
    var isEmpty: Bool { elements.isEmpty }
    
}

