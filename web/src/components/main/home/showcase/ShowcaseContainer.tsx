import {CodeBlock} from "@/components/ui/code-block.tsx";

export const ShowcaseContainer = () => {
    const code = `    public class Main {
        public static void main(String[] args) {
            System.out.println("Hello World!");
        }
    }`;

    return (
        <div className="mt-50 h-400">
            <div className="flex">
                <div className="flex-1 items-end">
                    A
                </div>
                <div className="flex-2">
                    <div className="flex gap-3">
                        <div className="flex-1">
                            <CodeBlock
                                language="java"
                                filename="DummyComponent.java"
                                highlightLines={[2]}
                                code={code}
                            />
                        </div>

                        <div className="flex-1">
                            <CodeBlock
                                language="java"
                                filename="DummyComponent.java"
                                highlightLines={[2]}
                                code={code}
                            />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};